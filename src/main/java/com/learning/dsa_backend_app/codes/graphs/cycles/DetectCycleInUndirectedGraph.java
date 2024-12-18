package com.learning.dsa_backend_app.codes.graphs.cycles;

import java.util.List;

public class DetectCycleInUndirectedGraph {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, adj))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(int u, int p, boolean[] vis, List<Integer>[] adj) {
        vis[u] = true;
        List<Integer> conn = adj[u];
        for (int v : conn) {
            if (!vis[v]) {
                if (dfs(v, u, vis, adj))
                    return true;
            } else if (v != p) {
                return true;
            }
        }
        return false;
    }
}
