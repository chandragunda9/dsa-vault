package com.learning.dsa_backend_app.codes.graphs.traversals;

public class NumberOfProvinces {
    //Method 1; Using DFS
    public int numProvinces1(int[][] adj) {
        int V = adj.length;
        boolean[] vis = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj);
                count++;
            }
        }
        return count;
    }

    void dfs(int v, boolean[] vis, int[][] adj) {
        vis[v] = true;
        int[] conn = adj[v];
        for (int adjV = 0; adjV < conn.length; adjV++) {
            if (adjV != v && conn[adjV] == 1 && !vis[adjV]) {
                dfs(adjV, vis, adj);
            }
        }
    }

    //Method 2; DisjointSet
    public int numProvinces(int[][] adj) {
        int n = adj.length;
        DisjointSet dis = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && adj[i][j] == 1) {
                    dis.unionBySize(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dis.findParent(i) == i)
                count++;
        }
        return count;
    }
}
