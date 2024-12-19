package com.learning.dsa_backend_app.codes.graphs.cycles;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraph {
    public boolean isCyclic(int N, List<Integer>[] adj) {
        //By using kahns algorithm
        int[] inDeg = new int[N];
        Queue<Integer> q = new LinkedList<>();

        for (List<Integer> conn : adj) {
            for (int v : conn) {
                inDeg[v]++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            Integer rem = q.poll();
            List<Integer> conn = adj[rem];
            for (int v : conn) {
                inDeg[v]--;
                if (inDeg[v] == 0)
                    q.add(v);
            }
        }

        for (int i = 0; i < N; i++) {
            if (inDeg[i] != 0)
                return true;
        }
        return false;
    }

    public boolean isCyclic1(int N, List<Integer>[] adj) {
        boolean[] currVis = new boolean[N];
        boolean[] vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                if (dfs(i, vis, currVis, adj))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(int u, boolean[] vis, boolean[] currVis, List<Integer>[] adj) {
        vis[u] = true;
        currVis[u] = true;
        List<Integer> conn = adj[u];
        for (int v : conn) {
            if (!vis[v]) {
                if (dfs(v, vis, currVis, adj))
                    return true;
            } else if (currVis[v])
                return true;
        }
        currVis[u] = false;
        return false;
    }
}
