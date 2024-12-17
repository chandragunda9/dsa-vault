package com.learning.dsa_backend_app.codes.graphs.traversals;

class NumberOfIslandsMethod2 {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        DisjointSet dis = new DisjointSet(n * m);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    traverseNeighbors(row, col, grid, dis);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = m * i + j;
                if (grid[i][j] == '1' && dis.findParent(val) == val) {
                    count++;
                }
            }
        }
        return count;
    }

    void traverseNeighbors(int row, int col, char[][] grid, DisjointSet dis) {
        int n = grid.length, m = grid[0].length;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0)
                    continue;

                int nRow = row + dr;
                int nCol = col + dc;

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1') {
                    int nodeVal = m * row + col;
                    int adjNodeVal = m * nRow + nCol;
                    dis.unionBySize(nodeVal, adjNodeVal);
                }
            }
        }
    }
}


