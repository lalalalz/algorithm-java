package com.company.kakao.dividePowerGrid;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int[][] wires;
    private int[][] connection;
    private Queue<Integer> queue = new LinkedList<>();
    boolean[] visited;

    public int solution(int n, int[][] input) {
        setConnection(n, input);
        return getAnswer(n);
    }

    private int getAnswer(int n) {
        int answer = 100;

        for (int removedWires = 0; removedWires < wires.length; removedWires++) {
            connection[wires[removedWires][0]][wires[removedWires][1]] = 0;
            connection[wires[removedWires][1]][wires[removedWires][0]] = 0;
            answer = Math.min(answer, bfs(removedWires, n));
            connection[wires[removedWires][0]][wires[removedWires][1]] = 1;
            connection[wires[removedWires][1]][wires[removedWires][0]] = 1;
        }

        return answer;
    }

    private int bfs(int removed, int n) {
        int nodeOfSubtree = 0;

        queue.add(1);
        visited = new boolean[n + 1];
        while (!queue.isEmpty()) {
            int firstNode = queue.poll();

            for (int secondNode = 1; secondNode <= n; secondNode++) {
                if (connection[firstNode][secondNode] > 0 && !visited[secondNode]) {
                    visited[secondNode] = true;
                    queue.add(secondNode);
                    nodeOfSubtree++;
                }
            }
        }

        return Math.abs((n - nodeOfSubtree) - nodeOfSubtree);
    }

    private void setConnection(int n, int[][] input) {
        wires = input;
        connection = new int[n + 1][n + 1];

        for (int[] node : wires) {
            connection[node[0]][node[1]] = 1;
            connection[node[1]][node[0]] = 1;
        }
    }
}