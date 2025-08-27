// Last updated: 8/27/2025, 12:54:15 PM
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a DP table with (m+1) rows and (n+1) columns
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    // If word1 is empty, all characters of word2 need to be inserted
                    dp[i][j] = j;
                } else if (j == 0) {
                    // If word2 is empty, all characters of word1 need to be deleted
                    dp[i][j] = i;
                } else {
                    // If characters match, no operation is needed
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // Otherwise, take the minimum of insertion, deletion, or substitution
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }
        }
        
        // The result is in the bottom-right corner of the table
        return dp[m][n];
    }
}
