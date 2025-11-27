// Last updated: 11/27/2025, 9:30:42 PM
1class Solution {
2    public long maxSubarraySum(int[] nums, int k) {
3        int n = nums.length;
4        long[] pref = new long[n + 1];
5        for (int i = 1; i <= n; i++) pref[i] = pref[i - 1] + nums[i - 1];
6
7        long[] minPref = new long[k];
8        for (int i = 0; i < k; i++) minPref[i] = Long.MAX_VALUE;
9        minPref[0] = 0;
10
11        long ans = Long.MIN_VALUE;
12
13        for (int i = 1; i <= n; i++) {
14            int rem = i % k;
15            if (minPref[rem] != Long.MAX_VALUE)
16                ans = Math.max(ans, pref[i] - minPref[rem]);
17            minPref[rem] = Math.min(minPref[rem], pref[i]);
18        }
19
20        return ans;
21    }
22}
23