package codility;

public class Task1 {
    public int solution(int[] A) {
        String representationOfV = representsNumberOfA(A);
        String multiply = multiply("71", representationOfV);
        return sumOfDigits(multiply);
    }

    private int sumOfDigits(String multiply) {
        int sum = 0;

        for (int i = 0; i < multiply.length(); i++) {
            sum += multiply.charAt(i) - '0';
        }

        return sum;
    }

    private String multiply(String seventeen, String representationOfV) {
        int roundedNumber;
        StringBuilder[] results = new StringBuilder[2];

        for (int i = 0; i < 2; i++) {
            roundedNumber = 0;
            results[i] = new StringBuilder();

            if (i == 1) {
                results[1].append("0");
            }

            for (int j = 0; j < representationOfV.length(); j++) {
                int a = seventeen.charAt(i) - '0';
                int b = representationOfV.charAt(j) - '0';

                String result = String.valueOf(a * b + roundedNumber);

                if (result.length() > 1) {
                    results[i].append(result.charAt(1) - '0');
                    roundedNumber = result.charAt(0) - '0';
                }

                else {
                    results[i].append(result.charAt(0) - '0');
                    roundedNumber = 0;
                }
            }
            results[i].append(roundedNumber);
        }

        return String.valueOf(Integer.valueOf(results[0].reverse().toString())
                + Integer.valueOf(results[1].reverse().toString()));
    }

    private String representsNumberOfA(int[] a) {
        StringBuilder stringBuilder = new StringBuilder("");

        for (int digit : a) {
            stringBuilder.append(digit);
        }

        return stringBuilder.toString();
    }
}
