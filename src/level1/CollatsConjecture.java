package level1;

public class CollatsConjecture {

    public int solution(long num) {
        int result = 0;

        while (num > 1 && result < 500) {
            if(num % 2 > 0) {
                num = num * 3 + 1;
            }
            else {
                num = num / 2;
            }
            result++;
        }

        if(result >= 500) {
            result = -1;
        }

        return result;
    }
}
