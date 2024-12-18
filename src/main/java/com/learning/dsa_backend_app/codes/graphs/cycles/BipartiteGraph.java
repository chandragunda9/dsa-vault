package com.learning.dsa_backend_app.codes.graphs.cycles;

import java.util.Arrays;
import java.util.List;

public class BipartiteGraph {
    public boolean isBipartite(int V, List<Integer>[] adj) {
        int[] colorsFilled = new int[V];
        Arrays.fill(colorsFilled, -1);
        for (int i = 0; i < V; i++) {
            if (colorsFilled[i] == -1) {
                if (!dfs(i, 0, colorsFilled, adj))
                    return false;
            }
        }
        return true;
    }

    boolean dfs(int u, int color, int[] colorsFilled, List<Integer>[] adj) {
        colorsFilled[u] = color;
        List<Integer> conn = adj[u];
        for (int v : conn) {
            if (colorsFilled[v] == -1) {
                if (!dfs(v, 1 - color, colorsFilled, adj))
                    return false;
            } else if (colorsFilled[v] == color) {
                return false;
            }
        }
        return true;
    }
}
