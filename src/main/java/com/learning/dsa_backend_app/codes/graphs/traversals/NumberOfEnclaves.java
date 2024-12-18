package com.learning.dsa_backend_app.codes.graphs.traversals;

class NumberOfEnclaves {
    public int numberOfEnclaves(int[][] grid) {
     int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        //first row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !vis[0][j]) {
                dfs(0, j, vis, grid);
            }
        }
        //first col
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !vis[i][0]) {
                dfs(i, 0, vis, grid);
            }
        }
        //last row
        for (int j = 0; j < m; j++) {
            if (grid[n - 1][j] == 1 && !vis[n - 1][j]) {
                dfs(n - 1, j, vis, grid);
            }
        }
        //last col
        for (int i = 0; i < n; i++) {
            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                dfs(i, m - 1, vis, grid);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j])
                    count++;
            }
        }
        return count;
    }

    void dfs(int row, int col, boolean[][] vis, int[][] grid) {
        vis[row][col] = true;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        for (int i = 0; i < dRow.length; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length &&
                    !vis[nRow][nCol] && grid[nRow][nCol] == 1) {
                vis[nRow][nCol] = true;
                dfs(nRow, nCol, vis, grid);
            }
        }
    }
}