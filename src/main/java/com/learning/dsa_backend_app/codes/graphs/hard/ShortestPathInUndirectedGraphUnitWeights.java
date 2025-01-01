package com.learning.dsa_backend_app.codes.graphs.hard;

import java.util.*;

public class ShortestPathInUndirectedGraphUnitWeights {
    public int[] shortestPath(int[][] edges, int N, int M) {
        Queue<Integer> q = new LinkedList<>();
        int[] minDist = new int[N];

        List<List<Integer>> adj = buildAdjacencyList(N, edges);

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        q.add(0);

        while (!q.isEmpty()) {
            Integer u = q.poll();
            List<Integer> conn = adj.get(u);
            for (Integer v : conn) {
                if (minDist[u] + 1 < minDist[v]) {
                    q.add(v);
                    minDist[v] = minDist[u] + 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (minDist[i] == Integer.MAX_VALUE)
                minDist[i] = -1;
        }
        return minDist;
    }

    public List<List<Integer>> buildAdjacencyList(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}
