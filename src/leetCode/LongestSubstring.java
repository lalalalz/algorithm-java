package leetCode;


public class LongestSubstring {

    public int lengthOfLongestSubstring(String str) {

        int lengthOfLongest = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            String target = String.valueOf(str.charAt(i));
            String substring = stringBuilder.substring(stringBuilder.indexOf(target) + 1);

            stringBuilder.replace(0, stringBuilder.length(), substring);
            stringBuilder.append(target);

            lengthOfLongest = Math.max(lengthOfLongest, stringBuilder.length());
        }

        return lengthOfLongest;
    }
}
