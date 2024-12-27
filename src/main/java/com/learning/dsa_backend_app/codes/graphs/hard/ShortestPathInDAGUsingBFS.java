package com.learning.dsa_backend_app.codes.graphs.hard;

import java.util.*;

public class ShortestPathInDAGUsingBFS {
    static class Node {
        int v, dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        List<List<Node>> adj = buildAdjacencyList(N, edges);
        int[] inDeg = new int[N];
        int[] dist = new int[N];
        Queue<Integer> q = new LinkedList<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int[] edge : edges) {
            inDeg[edge[1]]++;
        }

        for (int i = 0; i < N; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            List<Node> conn = adj.get(rem);

            for (Node v : conn) {
                inDeg[v.v]--;
                if (inDeg[v.v] == 0)
                    q.add(v.v);
                if (dist[rem] != Integer.MAX_VALUE && dist[rem] + v.dist < dist[v.v]) {
                    dist[v.v] = dist[rem] + v.dist;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }

    public List<List<Node>> buildAdjacencyList(int n, int[][] edges) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int dist = edge[2];
            adj.get(u).add(new Node(v, dist));
        }
        return adj;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 2, 6},
                {0, 3, 7},
                {0, 4, 9},
                {0, 6, 8},
                {0, 7, 6},
                {1, 2, 6},
                {1, 3, 7},
                {1, 5, 10},
                {1, 6, 1},
                {1, 7, 4},
                {2, 3, 3},
                {2, 6, 10},
                {2, 8, 8},
                {2, 9, 10},
                {3, 5, 3},
                {3, 6, 10},
                {3, 7, 5},
                {5, 6, 9},
                {5, 7, 7},
                {6, 7, 7},
                {6, 8, 8},
                {6, 9, 8},
                {7, 9, 1},
                {8, 9, 6}};
        int n = 10, m = 24;
        ShortestPathInDAGUsingBFS obj = new ShortestPathInDAGUsingBFS();
        System.out.println(Arrays.toString(obj.shortestPath(n, m, edges)));
    }
}
