// Last updated: 4/14/2026, 4:44:00 PM
class Solution {
    public int minTimeToVisitAllPoints(int[][] p) {
        int ans = 0;
        for (int i = 1; i < p.length; i++) {
            ans += Math.max(
                Math.abs(p[i][0] - p[i - 1][0]),
                Math.abs(p[i][1] - p[i - 1][1])
            );
        }
        return ans;
    }
}