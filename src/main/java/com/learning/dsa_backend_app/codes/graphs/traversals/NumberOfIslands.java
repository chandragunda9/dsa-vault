package com.learning.dsa_backend_app.codes.graphs.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    bfsTraversal(row, col, grid);
                    count++;
                }
            }
        }
        return count;
    }

    void bfsTraversal(int row, int col, char[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        grid[row][col] = '2';
        q.add(new Pair(row, col));
        while (!q.isEmpty()) {
            Pair top = q.poll();
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr == 0 && dc == 0)
                        continue;

                    int nRow = top.row + dr;
                    int nCol = top.col + dc;
                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                            grid[nRow][nCol] == '1') {
                        grid[nRow][nCol] = '2';
                        q.add(new Pair(nRow, nCol));
                    }
                }
            }
        }
    }
}
