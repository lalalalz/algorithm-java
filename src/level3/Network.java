package level3;

public class Network {

    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        int networkCount = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, n, computers);
                networkCount++;
            }
        }

        return networkCount;
    }

    private void dfs(int now, int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            if (!visited[i] && computers[now][i] == 1) {
                visited[i] = true;
                dfs(i, n, computers);
            }
        }
    }
}
