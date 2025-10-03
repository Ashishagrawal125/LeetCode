// Last updated: 10/3/2025, 11:34:26 PM
import java.util.*;

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<>();
        String result = "";
        built.add("");

        for (String word : words) {
            if (built.contains(word.substring(0, word.length() - 1))) {
                built.add(word);
                if (word.length() > result.length()) {
                    result = word;
                }
            }
        }
        return result;
    }
}
