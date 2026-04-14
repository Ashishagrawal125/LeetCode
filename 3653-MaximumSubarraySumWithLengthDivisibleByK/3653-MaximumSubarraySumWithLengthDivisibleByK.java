// Last updated: 4/14/2026, 4:42:31 PM
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] pref = new long[n + 1];
        for (int i = 1; i <= n; i++) pref[i] = pref[i - 1] + nums[i - 1];

        long[] minPref = new long[k];
        for (int i = 0; i < k; i++) minPref[i] = Long.MAX_VALUE;
        minPref[0] = 0;

        long ans = Long.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int rem = i % k;
            if (minPref[rem] != Long.MAX_VALUE)
                ans = Math.max(ans, pref[i] - minPref[rem]);
            minPref[rem] = Math.min(minPref[rem], pref[i]);
        }

        return ans;
    }
}
