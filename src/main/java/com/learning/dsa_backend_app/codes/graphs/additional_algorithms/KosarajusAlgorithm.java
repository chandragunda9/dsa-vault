package com.learning.dsa_backend_app.codes.graphs.additional_algorithms;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgorithm {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, st);
            }
        }

        //reverse the graph
        ArrayList<ArrayList<Integer>> revAdj = revAdj(V, adj, vis);
        int count = 0;
        while (!st.isEmpty()) {
            int u = st.pop();
            if (!vis[u]) {
                dfs2(u, revAdj, vis);
                count++;
            }
        }
        return count;
    }

    void dfs(int u, ArrayList<ArrayList<Integer>> ad, boolean[] vis, Stack<Integer> st) {
        vis[u] = true;
        ArrayList<Integer> conn = ad.get(u);
        for (int v : conn) {
            if (!vis[v]) {
                dfs(v, ad, vis, st);
            }
        }
        st.push(u);
    }

    void dfs2(int u, ArrayList<ArrayList<Integer>> ad, boolean[] vis) {
        vis[u] = true;
        ArrayList<Integer> conn = ad.get(u);
        for (int v : conn) {
            if (!vis[v]) {
                dfs2(v, ad, vis);
            }
        }
    }

    private ArrayList<ArrayList<Integer>> revAdj(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            revAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            vis[i] = false;
            ArrayList<Integer> conn = adj.get(i);
            for (int ele : conn) {
                revAdj.get(ele).add(i);
            }
        }
        return revAdj;
    }
}