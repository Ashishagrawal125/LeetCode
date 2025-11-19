// Last updated: 11/19/2025, 7:11:36 PM
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int x = l; x <= r; x++) {
                    dp[l][r] = Math.min(dp[l][r], x + Math.max(dp[l][x - 1], dp[x + 1][r]));
                }
            }
        }
        return dp[1][n];
    }
}
