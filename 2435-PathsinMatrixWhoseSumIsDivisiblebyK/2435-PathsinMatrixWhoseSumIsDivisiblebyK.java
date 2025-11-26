// Last updated: 11/26/2025, 11:24:18 PM
1class Solution {
2    public int numberOfPaths(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int mod = 1000000007;
6
7        int[][][] dp = new int[m][n][k];
8
9        dp[0][0][grid[0][0] % k] = 1;
10
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13
14                if (i == 0 && j == 0) continue;
15
16                for (int r = 0; r < k; r++) {
17
18                    int val = grid[i][j];
19                    int newR = (r + val) % k;
20
21                    if (i > 0)
22                        dp[i][j][newR] = (dp[i][j][newR] + dp[i-1][j][r]) % mod;
23
24                    if (j > 0)
25                        dp[i][j][newR] = (dp[i][j][newR] + dp[i][j-1][r]) % mod;
26                }
27            }
28        }
29
30        return dp[m-1][n-1][0];
31    }
32}
33