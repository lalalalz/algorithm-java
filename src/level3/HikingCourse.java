package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class HikingCourse {

    private int max = 10000001;
    private int[] minimumIntensityOfNode = new int[50001];
    private List<Node>[] graph = new ArrayList[50001];

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        init(n, paths);
        findAllHikingCourse(n, paths, gates, summits);
        return getMinimumIntensityCourse(summits);
    }

    private void init(int n, int[][] paths) {
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            minimumIntensityOfNode[i] = max;
        }

        for (int[] path : paths) {
            graph[path[0]].add(new Node(path[1], path[2]));
            graph[path[1]].add(new Node(path[0], path[2]));
        }
    }

    private int[] getMinimumIntensityCourse(int[] summits) {
        int minimumIntensity = max;
        int nodeOfMinimumIntensity = 0;
        int[] ints = Arrays.stream(summits)
                .sorted()
                .toArray();

        for (int summit : ints) {
            if (minimumIntensity > minimumIntensityOfNode[summit]) {
                minimumIntensity = minimumIntensityOfNode[summit];
                nodeOfMinimumIntensity = summit;
            }
        }

        return new int[]{nodeOfMinimumIntensity, minimumIntensity};
    }

    private void findAllHikingCourse(int n, int[][] paths, int[] gates, int[] summits) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        for (int gate : gates) {
            priorityQueue.add(new Node(gate, 0));
        }

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int now = node.nodeNumber;
            int intensity = node.intensity;

            if (isTopOfMountain(now, summits) || intensity > minimumIntensityOfNode[now]) {
                continue;
            }

            for (int i = 0; i < graph[now].size(); i++) {
                Node connectedNode = graph[now].get(i);

                int next = connectedNode.nodeNumber;
                int distanceOfPath = connectedNode.intensity;
                int newIntensity = Math.max(intensity, distanceOfPath);

                if (minimumIntensityOfNode[next] > newIntensity) {
                    minimumIntensityOfNode[next] = newIntensity;
                    priorityQueue.add(new Node(next, newIntensity));
                }
            }
        }
    }

    private boolean isTopOfMountain(int now, int[] summits) {
        return Arrays.stream(summits)
                .filter(s -> s == now)
                .count() > 0;
    }

    static class Node implements Comparable<Node> {
        int nodeNumber;
        int intensity;

        public Node(int nodeNumber, int intensity) {
            this.nodeNumber = nodeNumber;
            this.intensity = intensity;
        }

        @Override
        public int compareTo(Node o) {
            if(this.intensity > o.intensity) return 1;
            if(this.intensity < o.intensity) return -1;
            return 0;
        }
    }
}
