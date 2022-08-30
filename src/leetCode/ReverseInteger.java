package leetCode;

public class ReverseInteger {

    public int reverse(int integer) {
        String sign = getSign(integer);
        String number = getNumber(integer);
        String reversedNumber = getReversedNumber(number);

        return stringToInteger(sign, reversedNumber);
    }

    private String getReversedNumber(String number) {
        return new StringBuilder(number)
                .reverse()
                .toString();
    }

    private String getNumber(int integer) {
        String stringInteger = String.valueOf(integer);

        if(integer >= 0) return stringInteger;
        return stringInteger.substring(1);
    }

    private String getSign(int inputNumber) {
        if(inputNumber >= 0) return "+1";
        return "-1";
    }

    private int stringToInteger(String sign, String number) {
        if (!isOverflow(number)) {
            return Integer.valueOf(sign)
                    * Integer.valueOf(number);
        }

        return 0;
    }

    private boolean isOverflow(String integer) {
        String maxInteger = String.valueOf(Integer.MAX_VALUE);

        if(integer.length() > 10) return true;
        if(integer.length() < 10) return false;

        return integer.compareTo(maxInteger) < 0 ? false : true;
    }
}
