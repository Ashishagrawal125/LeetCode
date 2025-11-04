// Last updated: 11/4/2025, 11:12:37 PM
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n) dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }
}
