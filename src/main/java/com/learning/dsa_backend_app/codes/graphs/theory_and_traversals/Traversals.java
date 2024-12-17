package com.learning.dsa_backend_app.codes.graphs.theory_and_traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversals {
    public List<Integer> dfsOfGraph(int V, List<Integer> adj[]) {
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        dfs(0, vis, adj, ans);
        return ans;
    }

    void dfs(int u, boolean[] vis, List<Integer>[] adj, List<Integer> ans) {
        vis[u] = true;
        ans.add(u);
        List<Integer> conn = adj[u];
        for (int v : conn) {
            if (!vis[v]) {
                dfs(v, vis, adj, ans);
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<Integer> adj[]) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];

        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            List<Integer> conn = adj[rem];
            for (int v : conn) {
                if (!vis[v]) {
                    q.add(v);
                    vis[v] = true;
                }
            }
        }
        return ans;
    }
}
