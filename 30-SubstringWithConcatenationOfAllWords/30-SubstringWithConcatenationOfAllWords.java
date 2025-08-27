// Last updated: 8/27/2025, 12:54:45 PM
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() < words.length * words[0].length()) {
            return result;
        }

        // Length of each word and total length of all words combined
        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalWordLength = wordLength * wordCount;

        // Create a map for word frequencies
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Iterate over the string with different offsets (0 to wordLength - 1)
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            HashMap<String, Integer> windowMap = new HashMap<>();
            int count = 0;

            while (right + wordLength <= s.length()) {
                String currentWord = s.substring(right, right + wordLength);
                right += wordLength;

                // If the word is in the list of words
                if (wordMap.containsKey(currentWord)) {
                    windowMap.put(currentWord, windowMap.getOrDefault(currentWord, 0) + 1);

                    // Check if the frequency exceeds the frequency in wordMap
                    if (windowMap.get(currentWord) <= wordMap.get(currentWord)) {
                        count++;
                    } else {
                        // Shrink the window from the left
                        while (windowMap.get(currentWord) > wordMap.get(currentWord)) {
                            String leftWord = s.substring(left, left + wordLength);
                            windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                            if (windowMap.get(leftWord) < wordMap.get(leftWord)) {
                                count--;
                            }
                            left += wordLength;
                        }
                    }

                    // Check if we have found a valid substring
                    if (count == wordCount) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLength);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }
                } else {
                    // Reset the window if the word is not in the list
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
