package level1.숫자문자열과영단어;

/**
 * 문제: 숫자 문자열과 영단어
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/81301
 * <p>
 * === 문제 설명 ===
 * <p>
 * 네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
 * <p>
 * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
 * <p>
 * 1478 → "one4seveneight"
 * <p>
 * 234567 → "23four5six7"
 * <p>
 * 10203 → "1zerotwozero3"
 * <p>
 * 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.
 * <p>
 * 숫자	영단어
 * 0	zero
 * 1	one
 * 2	two
 * 3	three
 * 4	four
 * 5	five
 * 6	six
 * 7	seven
 * 8	eight
 * 9	nine
 * <p>
 * 제한사항
 * <p>
 * 1 ≤ s의 길이 ≤ 50
 * <p>
 * s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
 * <p>
 * return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.
 * <p>
 * 입출력 예
 * <p>
 * s	result
 * "one4seveneight"	1478
 * "23four5six7"	234567
 * "2three45sixseven"	234567
 * "123"	123
 * <p>
 * 입출력 예 설명
 * <p>
 * 입출력 예 #1 - 문제 예시와 같습니다.
 * <p>
 * 입출력 예 #2 - 문제 예시와 같습니다.
 * <p>
 * 입출력 예 #3 - "three"는 3, "six"는 6, "seven"은 7에 대응되기 때문에 정답은 입출력 예 #2와 같은 234567이 됩니다.
 * <p>
 * 입출력 예 #4 - s에는 영단어로 바뀐 부분이 없습니다.
 * <p>
 * 제한시간 안내 - 정확성 테스트 : 10초
 */
public class Solution {

    public int solution(String s) {
        String[] numberString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < numberString.length; i++) {
            String number = numberString[i];
            s = s.replaceAll(number, String.valueOf(i));
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution("2three45sixseven");
        System.out.println("solution1 = " + solution1);
    }
}
