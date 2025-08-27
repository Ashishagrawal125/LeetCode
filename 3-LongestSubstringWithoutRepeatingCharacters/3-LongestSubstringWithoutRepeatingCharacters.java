// Last updated: 8/27/2025, 12:55:05 PM
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0; // To store the maximum length of a substring
        int left = 0; // Left pointer of the sliding window

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            // If the character is already in the set, shrink the window
            while (set.contains(current)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set and update maxLength
            set.add(current);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}