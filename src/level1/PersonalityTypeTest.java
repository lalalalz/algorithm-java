package level1;

import java.util.HashMap;

public class PersonalityTypeTest {

    HashMap<String, Integer> resultOfTest = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        return getPersonalityType(survey, choices);
    }

    private String getPersonalityType(String[] survey, int[] choices) {

        for (int i = 0; i < choices.length; i++) {
            String problem = survey[i];
            String firstType = problem.substring(0, 1);
            String secondType = problem.substring(1, 2);

            if (choices[i] < 4) {
                Integer score = resultOfTest.getOrDefault(firstType, 0);
                score += Math.abs(choices[i] - 4);
                resultOfTest.put(firstType, score);
            }
            if (choices[i] > 4) {
                Integer score = resultOfTest.getOrDefault(secondType, 0);
                score += Math.abs(choices[i] - 4);
                resultOfTest.put(secondType, score);
            }
        }

        return judgePersonalityType();
    }

    private String judgePersonalityType() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(getDefiniteType("R", "T"));
        stringBuilder.append(getDefiniteType("C", "F"));
        stringBuilder.append(getDefiniteType("J", "M"));
        stringBuilder.append(getDefiniteType("A", "N"));

        return stringBuilder.toString();
    }

    private String getDefiniteType(String firstType, String secondType) {
        int firstTypeScore  = resultOfTest.getOrDefault(firstType, 0);
        int secondTypeScore = resultOfTest.getOrDefault(secondType, 0);

        if(firstTypeScore - secondTypeScore > 0) return firstType;
        if(firstTypeScore - secondTypeScore < 0) return secondType;

        if(firstType.compareTo(secondType) > 0) return secondType;
        return firstType;
    }
}
