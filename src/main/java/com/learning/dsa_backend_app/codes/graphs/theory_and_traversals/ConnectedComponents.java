package com.learning.dsa_backend_app.codes.graphs.theory_and_traversals;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
    public int findNumberOfComponent(int E, int V, List<List<Integer>> edges) {
        DisjointSet di = new DisjointSet(V);
        for (List<Integer> edge : edges) {
//            di.unionBySize(edge.get(0), edge.get(1));
            di.unionByRank(edge.get(0), edge.get(1));
        }
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (di.findParent(i) == i)
                count++;
        }
        return count;
    }

    //method 1
    public int findNumberOfComponent1(int E, int V, List<List<Integer>> edges) {
        int count = 0;
        List<List<Integer>> adj = buildAdjacencyList(V, edges);
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                count++;
            }
        }
        return count;
    }

    public List<List<Integer>> buildAdjacencyList(int u, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < u; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        return adj;
    }

    void dfs(int u, List<List<Integer>> adj, boolean[] vis) {
        vis[u] = true;
        List<Integer> conn = adj.get(u);
        for (int ele : conn) {
            if (!vis[ele]) {
                dfs(ele, adj, vis);
            }
        }
    }
}
