package com.learning.dsa_backend_app.codes.graphs.traversals;

import java.util.LinkedList;
import java.util.Queue;

class FloodFillAlgorithm {
    static class Cell {
        int row, col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        int srcColor = image[sr][sc];
        bfs(sr, sc, srcColor, newColor, image);
        return image;
    }

    static void bfs(int row, int col, int srcColor, int newColor, int[][] image) {
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(row, col));
        image[row][col] = newColor;
        while (!q.isEmpty()) {
            Cell rem = q.poll();
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int i = 0; i < dRow.length; i++) {
                int nRow = rem.row + dRow[i];
                int nCol = rem.col + dCol[i];
                if (nRow >= 0 && nRow < image.length && nCol >= 0 && nCol < image[0].length &&
                        image[nRow][nCol] == srcColor) {
                    q.add(new Cell(nRow, nCol));
                    image[nRow][nCol] = newColor;
                }
            }
        }
    }
}
