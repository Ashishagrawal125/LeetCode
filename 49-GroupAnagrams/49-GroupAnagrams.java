// Last updated: 8/27/2025, 12:54:31 PM
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Sort the characters in the string and use it as a key
            char[] chars = str.toCharArray();
            java.util.Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            // Add the original string to the list corresponding to the sorted key
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }
        
        // Return the values of the hashmap as a list of lists
        return new ArrayList<>(map.values());
    }
}
