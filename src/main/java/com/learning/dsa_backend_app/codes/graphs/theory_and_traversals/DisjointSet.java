package com.learning.dsa_backend_app.codes.graphs.theory_and_traversals;

public class DisjointSet {
    int[] parent;
    int[] sizes;
    int[] ranks;

    DisjointSet(int n) {
        parent = new int[n + 1];
        ranks = new int[n + 1];
        sizes = new int[n + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sizes[i] = 1;
            ranks[i] = 0;
        }
    }

    int findParent(int u) {
        if (u == parent[u])
            return u;
        return parent[u] = findParent(parent[u]);
    }

    public void unionBySize(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);
        if (rootU == rootV)
            return;
        if (sizes[rootU] < sizes[rootV]) {
            parent[rootU] = rootV;
            sizes[rootV] += sizes[rootU];
        } else {
            parent[rootV] = rootU;
            sizes[rootU] += sizes[rootV];
        }
    }

    public void unionByRank(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);
        if (rootU == rootV)
            return;

        if (ranks[rootU] < ranks[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootV] = rootU;
            if (ranks[rootU] == ranks[rootV])
                ranks[rootU]++;
        }
    }
}
