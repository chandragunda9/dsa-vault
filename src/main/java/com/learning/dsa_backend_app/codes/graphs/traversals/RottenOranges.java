package com.learning.dsa_backend_app.codes.graphs.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Cell {
        int row, col, time;

        public Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Cell> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    q.add(new Cell(i, j, 0));
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int maxTime = 0;
        while (!q.isEmpty()) {
            Cell rem = q.poll();
            maxTime = Math.max(maxTime, rem.time);
            for (int i = 0; i < drow.length; i++) {
                int nRow = rem.row + drow[i];
                int nCol = rem.col + dcol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && grid[nRow][nCol] == 1) {
                    grid[nRow][nCol] = 2;
                    q.add(new Cell(nRow, nCol, rem.time + 1));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        RottenOranges obj = new RottenOranges();
        System.out.println(obj.orangesRotting(grid));
    }
}
