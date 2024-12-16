package com.learning.dsa_backend_app.codes.graphs.theory_and_traversals;

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
}
