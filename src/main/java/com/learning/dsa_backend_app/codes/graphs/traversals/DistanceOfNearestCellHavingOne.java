package com.learning.dsa_backend_app.codes.graphs.traversals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHavingOne {
    static class Cell {
        int row, col, dist;

        public Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int[][] nearest(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};

        Queue<Cell> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Cell(i, j, 0));
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Cell rem = q.poll();
            for (int i = 0; i < 4; i++) {
                int nRow = rem.row + dRow[i];
                int nCol = rem.col + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && rem.dist + 1 < dist[nRow][nCol]) {
                    dist[nRow][nCol] = rem.dist + 1;
                    q.add(new Cell(nRow, nCol, dist[nRow][nCol]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    dist[i][j] = 0;
            }
        }
        return dist;
    }
}
