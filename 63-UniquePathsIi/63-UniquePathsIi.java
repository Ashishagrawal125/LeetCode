// Last updated: 8/27/2025, 12:54:23 PM
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // DP array to store the number of unique paths
        int[][] dp = new int[m][n];
        
        // If the starting cell is blocked, there are no paths
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Initialize the top-left cell
        dp[0][0] = 1;
        
        // Initialize the first column (can only move down)
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i-1][0]; // Can only come from the cell above
            }
        }
        
        // Initialize the first row (can only move right)
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j-1]; // Can only come from the cell to the left
            }
        }
        
        // Fill the DP table for the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) { // If not an obstacle
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; // Sum of paths from above and left
                }
            }
        }
        
        // The bottom-right corner holds the number of unique paths
        return dp[m-1][n-1];
    }
}
