package com.company.kakao.friendsBlock;

import java.util.Arrays;

public class FriendsBlock {

    private final char NONE = '0';
    private char[][] map;
    private int height;
    private int width;
    private int[][] dir = {{0,0}, {0, 1}, {1, 1}, {1, 0}};

    public int solution(int h, int w, String[] board) {
        int answer = 0;

        map = new char[h][w];
        for (int i = 0; i < h; i++) {
            map[i] = board[i].toCharArray();
        }
        height = h;
        width = w;

        while (true) {
            int removed = update();
            if(removed == 0) break;
            answer += removed;
        }

        return answer;
    }

    private int update() {
        int removed = deleteBlocks(findBlocks());
        updateMap();
        return removed;
    }

    private void updateMap() {
        for (int x = 0; x < width; x++) {
            for (int y = height - 1; y >= 0; y--) {
                for (int i = y; i < height; i++) {
                    if (i + 1 < height && map[i + 1][x] == NONE) {
                        map[i + 1][x] = map[i][x];
                        map[i][x] = NONE;
                    }
                }
            }
        }
    }

    private int deleteBlocks(boolean[][] removedBlocks) {
        int removed = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if(removedBlocks[y][x]) {
                    map[y][x] = NONE;
                    removed++;
                }
            }
        }

        return removed;
    }

    private boolean[][] findBlocks() {
        boolean[][] removedBlocks = new boolean[height][width];

        for (int y = 0; y < height - 1; y++) {
            for (int x = 0; x < width - 1; x++) {
                int blockType = map[y][x];
                if(blockType == NONE || !isRightBlock(y, x, blockType)) continue;

                for (int d = 0; d < 4; d++) {
                    int newY = y + dir[d][0];
                    int newX = x + dir[d][1];
                    removedBlocks[newY][newX] = true;
                }
            }
        }

        return removedBlocks;
    }

    private boolean isRightBlock(int y, int x, int blockType) {
        for (int d = 1; d < 4; d++) {
            int newY = y + dir[d][0];
            int newX = x + dir[d][1];
            if(map[newY][newX] != map[y][x]) return false;
        }
        return true;
    }
}
