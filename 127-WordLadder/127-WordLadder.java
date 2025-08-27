// Last updated: 8/27/2025, 12:53:47 PM
import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 1; // Start with the length of the beginning word

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return length;
                }

                // Generate all possible next words
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] chars = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[j] == c) continue; // Skip if the character is the same
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordSet.remove(nextWord); // Ensure we don't visit the same word again
                        }
                    }
                }
            }
            length++;
        }

        return 0; // No transformation found
    }
}
