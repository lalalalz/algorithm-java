package level1;

public class 두수의합 {

    public static void main(String[] args) {
        두수의합 두수의합 = new 두수의합();
        String add = 두수의합.add("0", "0");
        System.out.println("add = " + add);
    }

    public String solution(String a, String b) {
        return add(a, b);
    }

    public String add(String number1, String number2) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        StringBuilder result = new StringBuilder();

        if (number1.length() > number2.length()) {
            a.append(number1);
            b.append(number2);
        }
        else {
            a.append(number2);
            b.append(number1);
        }

        a.reverse();
        b.reverse();

        int round = 0;
        int augend = 0;
        int addend = 0;
        int sum = 0;

        for (int i = 0; i < a.length(); i++) {
            augend = a.charAt(i) - '0';
            if (i >= b.length()) {
                addend = 0;
            }
            else {
                addend = b.charAt(i) - '0';
            }
            sum = augend + addend + round;
            round = sum / 10;
            result.append(sum % 10);
        }

        if (round > 0) {
            result.append(round);
        }

        return result
                .reverse()
                .toString();
    }
}
