package com.learning.dsa_backend_app.codes.graphs.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int N, int[][] arr) {
        //order of tasks to be completed
        //By using Kahn's Algorithm
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int[] inDeg = new int[N];

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] a : arr) {
            adj.get(a[1]).add(a[0]);
            inDeg[a[0]]++;
        }
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            List<Integer> conn = adj.get(rem);
            for (int ele : conn) {
                inDeg[ele]--;
                if (inDeg[ele] == 0)
                    q.add(ele);
            }
        }
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] != 0) {
                return new int[]{};
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
