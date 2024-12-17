package com.learning.dsa_backend_app.codes.graphs.additional_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesInGraph {
    int timer = 0;

    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> E) {
        List<List<Integer>> bridges = new ArrayList<>();
        boolean[] vis = new boolean[V];
        int[] disTime = new int[V];
        int[] lowTime = new int[V];

        List<List<Integer>> adj = buildAdjList(V, E);

        dfs(0, -1, vis, disTime, lowTime, adj, bridges);
        return bridges;
    }

    private List<List<Integer>> buildAdjList(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        return adj;
    }

    void dfs(int u, int p, boolean[] vis, int[] disTime, int[] lowTime, List<List<Integer>> adj,
             List<List<Integer>> edges) {
        vis[u] = true;
        disTime[u] = lowTime[u] = timer++;
        List<Integer> conn = adj.get(u);
        for (int v : conn) {
            if (!vis[v]) {
                dfs(v, u, vis, disTime, lowTime, adj, edges);
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
                if (lowTime[v] > disTime[u]) {
                    //it is a bridge
                    edges.add(new ArrayList<>(Arrays.asList(u, v)));
                }
            } else if (v != p) {
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
            }
        }
    }
}
