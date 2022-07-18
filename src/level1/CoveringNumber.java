package level1;

public class CoveringNumber {

    public String solution(String phone_number) {
        StringBuilder stringBuilder = new StringBuilder(phone_number);

        for (int i = 0; i < stringBuilder.length() - 4; i++) {
            stringBuilder.replace(i, i + 1,"*");
        }

        return stringBuilder.toString();
    }
}
