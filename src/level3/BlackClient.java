package level3;

import java.util.HashSet;
import java.util.Set;

public class BlackClient {

    private boolean[] isVisited = new boolean[10];
    private Set<String> distinctBannedId = new HashSet<>();

    public int solution(String[] userIds, String[] bannedIds) {
        getNumberOfCases(0, userIds, bannedIds);
        return distinctBannedId.size();
    }

    private void getNumberOfCases(int index, String[] userIds, String[] bannedIds) {
        if (index >= bannedIds.length) {
            addDistinctBannedIds(userIds);
            return;
        }

        for (int i = 0; i < userIds.length; i++) {
            if (!isVisited[i] && isMatched(userIds[i], bannedIds[index])) {
                isVisited[i] = true;
                getNumberOfCases(index + 1, userIds, bannedIds);
                isVisited[i] = false;
            }
        }
    }

    private void addDistinctBannedIds(String[] userIds) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < userIds.length; i++) {
            if (isVisited[i]) {
                stringBuilder.append(userIds[i] + "0");
            }
        }

        distinctBannedId.add(stringBuilder.toString());
    }

    private boolean isMatched(String target, String regex) {
        if(target.length() != regex.length()) return false;

        for (int i = 0; i < target.length(); i++) {
            if (regex.charAt(i) != '*' && target.charAt(i) != regex.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
