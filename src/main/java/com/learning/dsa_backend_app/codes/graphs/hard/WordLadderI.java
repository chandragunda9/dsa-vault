package com.learning.dsa_backend_app.codes.graphs.hard;

import java.util.*;

public class WordLadderI {
    static class Node {
        String word;
        int length;

        public Node(String word, int length) {
            this.word = word;
            this.length = length;
        }
    }

    public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
        Queue<Node> q = new LinkedList<>();
        Set<String> se = new HashSet<>(wordList);

        q.add(new Node(startWord, 1));
        se.remove(startWord);
        while (!q.isEmpty()) {
            Node rem = q.poll();

            String word = rem.word;
            int len = rem.length;

            if (word.equals(targetWord)) {
                return len;
            }

            char[] wordArr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char origCh = word.charAt(i);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != origCh) {
                        wordArr[i] = ch;
                        String changed = new String(wordArr);
                        if (se.contains(changed)) {
                            q.add(new Node(changed, len + 1));
                            se.remove(changed);
                        }
                    }
                }
                wordArr[i] = origCh;
            }
        }
        return 0;
    }
}
