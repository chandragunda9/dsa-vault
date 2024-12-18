package com.learning.dsa_backend_app.codes.graphs.traversals;

public class SurroundedRegions {
    public char[][] fill(char[][] mat) {
        int n = mat.length, m = mat[0].length;
        //traverse boundary rows and columns
        boolean[][] vis = new boolean[n][m];
        //first col and last col
        for (int i = 0; i < n; i++) {
            //first col
            if (!vis[i][0] && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat);
            }
            //last col
            if (!vis[i][m - 1] && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, mat);
            }
        }

        //first row and last row
        for (int j = 0; j < m; j++) {
            //first row
            if (!vis[0][j] && mat[0][j] == 'O') {
                dfs(0, j, vis, mat);
            }
            //last row
            if (!vis[n - 1][j] && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, mat);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'O' && !vis[i][j]) {
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;
    }


    void dfs(int row, int col, boolean[][] vis, char[][] mat) {
        vis[row][col] = true;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        for (int i = 0; i < dRow.length; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if (nRow >= 0 && nRow < mat.length && nCol >= 0 && nCol < mat[0].length &&
                    mat[nRow][nCol] == 'O' && !vis[nRow][nCol]) {
                dfs(nRow, nCol, vis, mat);
            }
        }
    }
}
