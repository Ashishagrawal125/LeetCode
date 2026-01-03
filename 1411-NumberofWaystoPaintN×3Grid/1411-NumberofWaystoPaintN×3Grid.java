// Last updated: 1/3/2026, 11:41:13 PM
1class Solution {
2    public int numOfWays(int n) {
3        final int MOD = 1000000007;
4        long x = 6, y = 6;
5        
6        for (int i = 2; i <= n; i++) {
7            long new_x = (3 * x + 2 * y) % MOD;
8            long new_y = (2 * x + 2 * y) % MOD;
9            x = new_x;
10            y = new_y;
11        }
12        
13        return (int)((x + y) % MOD);
14    }
15}