package level2;

public class BinaryTransformation {

    private int removedZeros = 0;
    private int convertedCounts = 0;

    public int[] solution(String input) {
        String number = input;

        while (number.equals("1") == false) {
            number = convert(removeZero(number).length());
        }

        return new int[] {convertedCounts, removedZeros};
    }

    private String convert(int length) {
        convertedCounts++;
        return Integer.toBinaryString(length);
    }

    private String removeZero(String number) {
        StringBuilder stringBuilder = new StringBuilder(number);

        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '0') {
                removedZeros++;
                stringBuilder.deleteCharAt(i);
                i--;
            }
        }

        return stringBuilder.toString();
    }
}
