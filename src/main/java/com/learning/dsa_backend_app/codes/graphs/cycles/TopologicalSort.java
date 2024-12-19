package com.learning.dsa_backend_app.codes.graphs.cycles;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSort {
    //By using DFS
    public int[] topoSort1(int V, List<Integer>[] adj) {
        //By using DFS
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        List<Integer> ans = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    void dfs(int u, boolean[] vis, List<Integer>[] adj, Stack<Integer> st) {
        vis[u] = true;
        List<Integer> conn = adj[u];
        for (int v : conn) {
            if (!vis[v]) {
                dfs(v, vis, adj, st);
            }
        }
        st.push(u);
    }

    public int[] topoSort(int V, List<Integer>[] adj) {
        //By using BFS (Kahn's algorithm)
        Queue<Integer> q = new LinkedList<>();
        int[] inDeg = new int[V];
        List<Integer> ans = new ArrayList<>();

        for (List<Integer> conn : adj) {
            for (int v : conn) {
                inDeg[v]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            List<Integer> conn = adj[rem];
            for (int v : conn) {
                inDeg[v]--;
                if (inDeg[v] == 0)
                    q.add(v);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int V = 6;
        int[][] arr = {{}, {}, {3}, {1}, {0, 1}, {0, 2}};
        TopologicalSort obj = new TopologicalSort();
        List<Integer>[] li = Arrays.stream(arr).map(a -> Arrays.stream(a).boxed().toList()).toArray(List[]::new);
        System.out.println(Arrays.toString(obj.topoSort1(V, li)));
    }
}
