// Last updated: 12/17/2025, 10:25:27 PM
1class Solution {
2
3    private int[] prices;
4    private long[][][] memo;
5
6    public long maximumProfit(int[] prices, int k) {
7        this.prices = prices;
8        int n = prices.length;
9        memo = new long[n][k + 1][3];
10        for (int i = 0; i < n; i++) {
11            for (int j = 0; j <= k; j++) {
12                for (int s = 0; s < 3; s++) {
13                    memo[i][j][s] = -1;
14                }
15            }
16        }
17        return dfs(n - 1, k, 0);
18    }
19
20    private long dfs(int i, int j, int state) {
21        if (j == 0) {
22            return 0;
23        }
24        if (i == 0) {
25            return state == 0 ? 0 : (state == 1 ? -prices[0] : prices[0]);
26        }
27        if (memo[i][j][state] != -1) {
28            return memo[i][j][state];
29        }
30
31        int p = prices[i];
32        long res;
33        if (state == 0) {
34            res = Math.max(
35                dfs(i - 1, j, 0),
36                Math.max(dfs(i - 1, j, 1) + p, dfs(i - 1, j, 2) - p)
37            );
38        } else if (state == 1) {
39            res = Math.max(dfs(i - 1, j, 1), dfs(i - 1, j - 1, 0) - p);
40        } else {
41            res = Math.max(dfs(i - 1, j, 2), dfs(i - 1, j - 1, 0) + p);
42        }
43        memo[i][j][state] = res;
44        return res;
45    }
46}