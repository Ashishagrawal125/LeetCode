// Last updated: 11/1/2025, 10:48:51 PM
class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26];
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || 
                         (s.charAt(i - 1) == 'z' && s.charAt(i) == 'a'))) {
                k++;
            } else {
                k = 1;
            }
            int index = s.charAt(i) - 'a';
            dp[index] = Math.max(dp[index], k);
        }

        int result = 0;
        for (int val : dp) result += val;
        return result;
    }
}

