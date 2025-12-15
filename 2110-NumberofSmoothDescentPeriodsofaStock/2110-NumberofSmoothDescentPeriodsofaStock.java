// Last updated: 12/15/2025, 1:31:05 PM
1class Solution {
2    public long getDescentPeriods(int[] prices) {
3        long ans = 0;
4        int cnt = 0;
5        for (int i = 0; i < prices.length; i++) {
6            if (i > 0 && prices[i] == prices[i - 1] - 1) {
7                cnt++;
8            } else {
9                cnt = 1;
10            }
11            ans += cnt;
12        }
13        return ans;
14    }
15}
16