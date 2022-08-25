package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Delivery {

    private int[] minimumDeliveryTime = new int[51];
    private List<Integer[]>[] roads = new ArrayList[51];

    public int solution(int N, int[][] road, int K) {
        init(N, road);
        return dijkstra(N, road, K);
    }

    private void init(int N, int[][] road) {
        for (int i = 1; i <= N; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int distance = road[i][2];

            roads[a].add(new Integer[]{b, distance});
            roads[b].add(new Integer[]{a, distance});
        }
    }

    private int dijkstra(int n, int[][] road, int k) {
        int possibleTown = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();

        Arrays.fill(minimumDeliveryTime, Integer.MAX_VALUE);
        minimumDeliveryTime[1] = 0;
        priorityQueue.add(new Node(1, 0));

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int now = node.id;
            int deliveryTime = node.deliveryTime;

            if (deliveryTime > minimumDeliveryTime[now]) {
                continue;
            }

            for (int i = 0; i < roads[now].size(); i++) {
                int next = roads[now].get(i)[0];
                int travelTime = roads[now].get(i)[1];
                int newDeliveryTime = deliveryTime + travelTime;

                if (newDeliveryTime < minimumDeliveryTime[next]) {
                    minimumDeliveryTime[next] = newDeliveryTime;
                    priorityQueue.add(new Node(next, newDeliveryTime));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (minimumDeliveryTime[i] <= k) {
                possibleTown++;
            }
        }

        return possibleTown;
    }

    public static class Node implements Comparable<Node> {
        int id;
        int deliveryTime;

        public Node(int id, int deliveryTime) {
            this.id = id;
            this.deliveryTime = deliveryTime;
        }

        @Override
        public int compareTo(Node o) {
            if(this.deliveryTime > o.deliveryTime) return -1;
            if(this.deliveryTime < o.deliveryTime) return  1;
            return 0;
        }
    }
}
