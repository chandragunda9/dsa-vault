package com.learning.dsa_backend_app.codes.graphs.additional_algorithms;

import java.util.ArrayList;

public class ArticulationPoints {
    int timer = 0;

    public ArrayList<Integer> articulationPoints(int n,
                                                 ArrayList<ArrayList<Integer>> adj) {
        boolean[] isArt = new boolean[n];
        boolean[] vis = new boolean[n];
        int[] disTime = new int[n];
        int[] lowTime = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, disTime, lowTime, adj, isArt);
            }
        }
        for (int i = 0; i < n; i++) {
            if (isArt[i])
                ans.add(i);
        }
        if (ans.isEmpty()) {
            ans.add(-1);
        }
        return ans;
    }

    void dfs(int u, int p, boolean[] vis, int[] disTime, int[] lowTime,
             ArrayList<ArrayList<Integer>> adj, boolean[] isArt) {
        disTime[u] = lowTime[u] = timer++;
        vis[u] = true;
        ArrayList<Integer> conn = adj.get(u);
        int child = 0;
        for (int v : conn) {
            if (!vis[v]) {
                dfs(v, u, vis, disTime, lowTime, adj, isArt);
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
                if (lowTime[v] >= disTime[u] && p != -1) {
                    isArt[u] = true;
                }
                child++;
            } else if (v != p) {
                lowTime[u] = Math.min(lowTime[u], disTime[v]);
            }
        }

        if (p == -1 && child > 1) {
            isArt[u] = true;
        }
    }
}
