package level3;

public class WayToSchool {

    private final int MAX = 51;
    private boolean[] isVisited = new boolean[50];

    public int solution(String begin, String target, String[] words) {
        int minimumSteps = getMinimumSteps(begin, target, words);

        if (minimumSteps == MAX) return 0;
        return minimumSteps;
    }

    private int getMinimumSteps(String begin, String target, String[] words) {
        int minimumSteps = MAX;

        if(begin.equals(target)) return 0;

        for (int i = 0; i < words.length; i++) {
            if (!isVisited[i] && canConvert(begin, words[i])) {
                isVisited[i] = true;
                minimumSteps = Math.min(minimumSteps, getMinimumSteps(words[i], target, words) + 1);
                isVisited[i] = false;
            }
        }

        return minimumSteps;
    }

    private boolean canConvert(String word, String target) {
        int numberOfSameCharacter = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                numberOfSameCharacter++;
            }
        }

        return numberOfSameCharacter == 1;
    }
}
