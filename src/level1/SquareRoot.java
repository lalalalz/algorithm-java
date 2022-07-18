package level1;

public class SquareRoot {

    public long solution(long n) {
        long squareRootPlusOne = getSquareRoot(n) + 1;

        if(squareRootPlusOne == 0) return -1;
        return squareRootPlusOne * squareRootPlusOne;
    }

    private long getSquareRoot(long n) {
        long squareRoot = -1;

        for (long i = 1; i * i <= n; i++) {
            if (i * i == n) {
                squareRoot = i;
                break;
            }
        }

        return squareRoot;
    }
}
