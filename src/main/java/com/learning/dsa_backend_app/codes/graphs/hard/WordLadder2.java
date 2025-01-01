package com.learning.dsa_backend_app.codes.graphs.hard;

import java.util.*;

public class WordLadder2 {
    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
        Queue<List<String>> q = new LinkedList<>();
        List<List<String>> ans = new ArrayList<>();
        Set<String> se = new HashSet<>(wordList);
        List<String> usedWordsOnPreLevels = new ArrayList<>();

        q.add(Collections.singletonList(beginWord));
        int level = 0;
        while (!q.isEmpty()) {
            List<String> rem = q.poll();
            if (rem.size() > level) {
                usedWordsOnPreLevels.forEach(se::remove);
                level++;
            }
            String lastWord = rem.get(rem.size() - 1);
            if (lastWord.equals(endWord)) {
                ans.add(new ArrayList<>(rem));
                continue;
            }

            char[] wordArr = lastWord.toCharArray();
            for (int i = 0; i < lastWord.length(); i++) {
                char origCh = wordArr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != origCh) {
                        wordArr[i] = ch;
                        String changed = new String(wordArr);
                        if (se.contains(changed)) {
                            List<String> li = new ArrayList<>(rem);
                            li.add(changed);
                            usedWordsOnPreLevels.add(changed);
                            q.add(li);
                        }
                    }
                }

                wordArr[i] = origCh;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WordLadder2 obj = new WordLadder2();
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};

        List<String> li = Arrays.stream(wordList).toList();

        System.out.println(obj.findSequences(startWord, targetWord, li));
    }
}
