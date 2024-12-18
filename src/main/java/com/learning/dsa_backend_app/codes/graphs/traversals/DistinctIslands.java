package com.learning.dsa_backend_app.codes.graphs.traversals;

import java.util.*;

public class DistinctIslands {
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Set<List<List<Integer>>> se = new HashSet<>();
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    List<List<Integer>> temp = new ArrayList<>();
                    dfs(i, j, i, j, vis, temp, grid);
                    se.add(temp);
                }
            }
        }
        return se.size();
    }

    void dfs(int row, int col, int baseRow, int baseCol,
             boolean[][] vis, List<List<Integer>> temp, int[][] grid) {
        vis[row][col] = true;
        temp.add(Arrays.asList(row - baseRow, col - baseCol));
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        for (int i = 0; i < dRow.length; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 &&
                    nCol < grid[0].length && !vis[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, baseRow, baseCol, vis, temp, grid);
            }
        }
    }
}
