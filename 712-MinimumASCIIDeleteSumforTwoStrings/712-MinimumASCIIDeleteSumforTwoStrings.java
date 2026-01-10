// Last updated: 1/10/2026, 3:04:08 PM
1class Solution {
2    public int minimumDeleteSum(String s1, String s2) {
3        int n = s1.length(), m = s2.length();
4        int[][] dp = new int[n + 1][m + 1];
5
6        for (int i = 0; i < n; i++) {
7            for (int j = 0; j < m; j++) {
8                if (s1.charAt(i) == s2.charAt(j))
9                    dp[i + 1][j + 1] = dp[i][j] + s1.charAt(i);
10                else
11                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
12            }
13        }
14
15        int total = 0;
16        for (char c : s1.toCharArray()) total += c;
17        for (char c : s2.toCharArray()) total += c;
18
19        return total - 2 * dp[n][m];
20    }
21}