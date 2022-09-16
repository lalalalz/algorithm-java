package level2;

public class BigNumber {

    public String solution(String number, int k) {
        return getBigNumber(number, number.length() - k);
    }

    private String getBigNumber(String number, int k) {
        StringBuilder stringBuilder = new StringBuilder(); 
        
        for (int i = k; i >= 1; i--) {
            String numberOfBestChoice = getBestChoice(number, i);
            stringBuilder.append(numberOfBestChoice);
            number = number.substring(number.indexOf(numberOfBestChoice) + 1);
        }

        return stringBuilder.toString();
    }

    private String getBestChoice(String number, int n) {
        int length = number.length();
        if (length == 1) return number;

        String possibleNumbers = number.substring(0, length - n + 1);
        return findBestChoice(possibleNumbers);
    }

    private String findBestChoice(String possibleNumbers) {
        return String.valueOf((char) possibleNumbers.chars().max().getAsInt());
    }
}