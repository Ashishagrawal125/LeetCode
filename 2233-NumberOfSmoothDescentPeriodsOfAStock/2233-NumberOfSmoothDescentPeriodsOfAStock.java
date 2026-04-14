// Last updated: 4/14/2026, 4:43:13 PM
class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int cnt = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] == prices[i - 1] - 1) {
                cnt++;
            } else {
                cnt = 1;
            }
            ans += cnt;
        }
        return ans;
    }
}
