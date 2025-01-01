package com.learning.dsa_backend_app.codes.graphs.shortest_path_algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstrasAlgorithm {
    static class Node {
        int node;
        int edgeWt;

        public Node(int node, int edgeWt) {
            this.node = node;
            this.edgeWt = edgeWt;
        }
    }

    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] minDist = new int[V];
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.edgeWt));

        q.add(new Node(S, 0));
        Arrays.fill(minDist, (int) 1e9);
        minDist[S] = 0;

        while (!q.isEmpty()) {
            Node rem = q.poll();
            ArrayList<ArrayList<Integer>> conn = adj.get(rem.node);

            for (ArrayList<Integer> it : conn) {
                int v = it.get(0);
                int edgeWt = it.get(1);
                if (minDist[rem.node] + edgeWt < minDist[v]) {
                    minDist[v] = minDist[rem.node] + edgeWt;
                    q.add(new Node(v, minDist[v]));
                }
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        int[][][] arr = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};
        ArrayList<ArrayList<ArrayList<Integer>>> li = Arrays.stream(arr).map(ar -> Arrays.stream(ar).
                map(a -> Arrays.stream(a).boxed().collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new))).collect(Collectors.toCollection(ArrayList::new));

        DijkstrasAlgorithm obj = new DijkstrasAlgorithm();
        System.out.println(Arrays.toString(obj.dijkstra(3, li, 2)));
    }
}
