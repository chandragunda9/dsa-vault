package com.learning.dsa_backend_app.other.codes;

import java.util.*;
import java.util.stream.Collectors;

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class DijkstrasAlgorithmUsingSet2 {
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        ArrayList<Integer> minDist = new ArrayList<>(Collections.nCopies(adj.size(), (int) 1e9));

        minDist.set(src, 0);

        TreeSet<int[]> ts = new TreeSet<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        ts.add(new int[]{0, src});

        while (!ts.isEmpty()) {
            int[] rem = ts.pollFirst();
            int u = rem[1];
            ArrayList<iPair> conn = adj.get(u);
            for (iPair it : conn) {
                int v = it.first;
                int wt = it.second;
                if (minDist.get(u) + wt < minDist.get(v)) {
                    ts.remove(new int[]{minDist.get(v), v});
                    minDist.set(v, minDist.get(u) + wt);
                    ts.add(new int[]{minDist.get(v), v});
                }
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
//        int[][][] arr = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};

        iPair[][] arr = {{new iPair(1, 9), new iPair(2, 1), new iPair(3, 1)},
                {new iPair(0, 9), new iPair(3, 3)},
                {new iPair(0, 1), new iPair(3, 2)},
                {new iPair(0, 1), new iPair(1, 3), new iPair(2, 2)}};
        ArrayList<ArrayList<iPair>> li = Arrays.stream(arr).map(ar ->
                        Arrays.stream(ar).collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));

        DijkstrasAlgorithmUsingSet2 obj = new DijkstrasAlgorithmUsingSet2();
        System.out.println(obj.dijkstra(li, 0));
    }
}
