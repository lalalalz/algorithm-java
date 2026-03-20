package level1.개인정보;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * today는 "YYYY.MM.DD" 형태로 오늘 날짜를 나타냅니다.
 * 1 ≤ terms의 길이 ≤ 20
 * terms의 원소는 "약관 종류 유효기간" 형태의 약관 종류와 유효기간을 공백 하나로 구분한 문자열입니다.
 * 약관 종류는 A~Z중 알파벳 대문자 하나이며, terms 배열에서 약관 종류는 중복되지 않습니다.
 * 유효기간은 개인정보를 보관할 수 있는 달 수를 나타내는 정수이며, 1 이상 100 이하입니다.
 * 1 ≤ privacies의 길이 ≤ 100
 * privacies[i]는 i+1번 개인정보의 수집 일자와 약관 종류를 나타냅니다.
 * privacies의 원소는 "날짜 약관 종류" 형태의 날짜와 약관 종류를 공백 하나로 구분한 문자열입니다.
 * 날짜는 "YYYY.MM.DD" 형태의 개인정보가 수집된 날짜를 나타내며, today 이전의 날짜만 주어집니다.
 * privacies의 약관 종류는 항상 terms에 나타난 약관 종류만 주어집니다.
 * today와 privacies에 등장하는 날짜의 YYYY는 연도, MM은 월, DD는 일을 나타내며 점(.) 하나로 구분되어 있습니다.
 * 2000 ≤ YYYY ≤ 2022
 * 1 ≤ MM ≤ 12
 * MM이 한 자릿수인 경우 앞에 0이 붙습니다.
 * 1 ≤ DD ≤ 28
 * DD가 한 자릿수인 경우 앞에 0이 붙습니다.
 * 파기해야 할 개인정보가 하나 이상 존재하는 입력만 주어집니다.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
        System.out.println("solution1 = " + solution1);
    }

    public int[] solution(String todayString, String[] termsString, String[] privaciesString) {
        SortedSet<Integer> answer = new TreeSet<>();
        // 이용약관 매핑
        Map<Character, Integer> map = new HashMap<>();
        for (String terms : termsString) {
            String[] split = terms.split(" ");
            String termType = split[0];
            int period = Integer.parseInt(split[1]) * 28;
            map.put(termType.charAt(0), period);
        }

        // 날짜 일단위로 변환
        int today = convert(todayString);
        for (int i = 0; i < privaciesString.length; i++) {
            String[] split = privaciesString[i].split(" ");

            int date = convert(split[0]);
            char termType = split[1].charAt(0);
            Integer period = map.get(termType);

            // 유효기간이 벗어났는지 판단
            if (date + period <= today) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int convert(String date) {
        String[] split = date.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return year * 12 * 28 + month * 28 + day;
    }
}
