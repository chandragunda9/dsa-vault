package com.learning.dsa_backend_app.codes.graphs.hard;

import java.util.*;

public class EventualSafeStates {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        //using BFS
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] inDeg = new int[V];

        int[][] revGraph = reversedGraph(V, adj);

        for (int i = 0; i < V; i++) {
            int[] conn = revGraph[i];
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
            int[] conn = revGraph[rem];
            for (int v : conn) {
                inDeg[v]--;
                if (inDeg[v] == 0)
                    q.add(v);
            }
        }
        Collections.sort(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    int[][] reversedGraph(int u, int[][] adj) {
        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < u; i++) {
            rev.add(new ArrayList<>());
        }
        for (int i = 0; i < u; i++) {
            int[] conn = adj[i];
            for (int v : conn) {
                rev.get(v).add(i);
            }
        }
        return rev.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }

    public int[] eventualSafeNodes1(int V, int[][] adj) {
        //using DFS
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] currVis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, currVis, adj, ans);
            }
        }
        Collections.sort(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    boolean dfs(int u, boolean[] vis, boolean[] currVis, int[][] adj, List<Integer> ans) {
        vis[u] = true;
        currVis[u] = true;
        int[] conn = adj[u];
        for (int v : conn) {
            if (!vis[v]) {
                if (dfs(v, vis, currVis, adj, ans))
                    return true;
            } else if (currVis[v]) {
                return true;
            }
        }
        currVis[u] = false;
        ans.add(u);
        return false;
    }

    public static void main(String[] args) {
        int[][] adj = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        EventualSafeStates obj=new EventualSafeStates();
        System.out.println(Arrays.toString(obj.eventualSafeNodes(7, adj)));
    }
}
