package level1.달리기경주;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            int index = map.get(calling);
            String slower = players[index];
            String faster = players[index - 1];

            // map 갱신
            map.put(faster, index);
            map.put(slower, index - 1);

            // 플레이어 배열 갱신
            players[index] = faster;
            players[index - 1] = slower;
        }

        return players;
    }
}
