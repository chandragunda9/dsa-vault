package com.learning.dsa_backend_app.codes.graphs.shortest_path_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DijkstrasAlgorithmUsingSet {
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] minDist = new int[V];
        Arrays.fill(minDist, (int) 1e9);
        minDist[S] = 0;

        TreeSet<int[]> ts = new TreeSet<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        ts.add(new int[]{0, S});

        while (!ts.isEmpty()) {
            int[] rem = ts.pollFirst();
            int u = rem[1];
            ArrayList<ArrayList<Integer>> conn = adj.get(u);
            for (ArrayList<Integer> it : conn) {
                int v = it.get(0);
                int wt = it.get(1);
                if (minDist[u] + wt < minDist[v]) {
                    ts.remove(new int[]{minDist[v], v});
                    minDist[v] = minDist[u] + wt;
                    ts.add(new int[]{minDist[v], v});
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

        DijkstrasAlgorithmUsingSet obj = new DijkstrasAlgorithmUsingSet();
        System.out.println(Arrays.toString(obj.dijkstra(3, li, 2)));
    }
}
