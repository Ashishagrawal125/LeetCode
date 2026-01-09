// Last updated: 1/9/2026, 10:56:07 AM
1class Solution {
2    int[] nums1, nums2;
3    int[][] memo;
4    int n, m;
5    final int NEG_INF = (int) -1e9;
6
7    int dp(int i, int j) {
8        if (i == n || j == m)
9            return NEG_INF;
10
11        if (memo[i][j] != Integer.MIN_VALUE)
12            return memo[i][j];
13
14        int take = nums1[i] * nums2[j];
15
16        int res = Math.max(
17            Math.max(
18                take + dp(i + 1, j + 1), // take both and continue
19                take                    // take and end here
20            ),
21            Math.max(
22                dp(i + 1, j),           // skip nums1[i]
23                dp(i, j + 1)            // skip nums2[j]
24            )
25        );
26
27        return memo[i][j] = res;
28    }
29
30    public int maxDotProduct(int[] a, int[] b) {
31        nums1 = a;
32        nums2 = b;
33        n = nums1.length;
34        m = nums2.length;
35
36        memo = new int[n][m];
37        for (int i = 0; i < n; i++)
38            Arrays.fill(memo[i], Integer.MIN_VALUE);
39
40        return dp(0, 0);
41    }
42}