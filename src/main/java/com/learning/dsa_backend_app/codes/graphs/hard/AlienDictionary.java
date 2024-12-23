package com.learning.dsa_backend_app.codes.graphs.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public String findOrder(String[] dict, int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        int[] inDeg = new int[K];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String a = dict[i];
            String b = dict[i + 1];

            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                int node1 = a.charAt(j) - 'a';
                int node2 = b.charAt(j) - 'a';

                if (node1 != node2) {
                    adj.get(node1).add(node2);
                    inDeg[node2]++;
                    break;
                }
            }
        }

        for (int i = 0; i < K; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            char ch = (char) (rem + (int) 'a');
            sb.append(ch);
            List<Integer> conn = adj.get(rem);
            for (int v : conn) {
                inDeg[v]--;
                if (inDeg[v] == 0)
                    q.add(v);
            }
        }
        return sb.toString();
    }
}
