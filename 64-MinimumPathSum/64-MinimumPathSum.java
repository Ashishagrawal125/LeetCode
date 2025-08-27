// Last updated: 8/27/2025, 12:54:22 PM
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // DP array to store the minimum path sum
        int[][] dp = new int[m][n];
        
        // Initialize the top-left corner
        dp[0][0] = grid[0][0];
        
        // Initialize the first row (can only move right)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        
        // Initialize the first column (can only move down)
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        
        // Fill the DP table for the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        
        // The bottom-right corner holds the minimum path sum
        return dp[m-1][n-1];
    }
}
