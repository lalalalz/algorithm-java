package level1.바탕화면정리;

public class Solution {
    public int[] solution(String[] wallpaper) {
        int startY = 50;
        int startX = 50;
        int endY = 0;
        int endX = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    startY = Math.min(startY, i);
                    startX = Math.min(startX, j);
                    endY = Math.max(endY, i + 1);
                    endX = Math.max(endX, j + 1);
                }
            }
        }

        return new int[]{startY, startX, endY, endX};
    }
}
