package level2;

public class HowToLineUp {

    private final long[] cache = new long[21];
    private final boolean[] visited = new boolean[21];

    public int[] solution(int n, long k) {
        int[] result = new int[n];

        factorial(n);
        getKthSequence(n, n, k, result);
        
        return result;
    }

    // n명의 사람을 일렬로 줄을 세울 수 있는 방법
    private long factorial(int n) {
        if(n <= 0) return 1;

        long result = cache[n];
        if(result > 0) return result;

        result = n * factorial(n - 1);
        return cache[n] = result;
    }

    private void getKthSequence(int index, int n, long k, int[] result) {
        if(index == 0) return;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && factorial(index - 1) < k) {
                k -= factorial(index - 1);
                continue;
            }

            if(!visited[i] && factorial(index - 1) >= k) {
                visited[i] = true;
                result[n - index] = i;
                getKthSequence(index - 1, n, k, result);
            }
        }
    }
}
