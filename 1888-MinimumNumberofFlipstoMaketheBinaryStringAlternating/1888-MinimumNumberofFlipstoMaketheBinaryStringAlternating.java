// Last updated: 3/7/2026, 10:28:41 PM
1class Solution {
2
3    public int minFlips(String s) {
4        int n = s.length();
5        int[][] pre = new int[n][2];
6
7        for (int i = 0; i < n; i++) {
8            char ch = s.charAt(i);
9            // Compute the prefix array
10            pre[i][0] = (i == 0 ? 0 : pre[i - 1][1]) + (ch == '1' ? 1 : 0);
11            pre[i][1] = (i == 0 ? 0 : pre[i - 1][0]) + (ch == '0' ? 1 : 0);
12        }
13
14        int ans = Math.min(pre[n - 1][0], pre[n - 1][1]);
15        // If the length is odd, consider the move operation
16        if (n % 2 == 1) {
17            int[][] suf = new int[n][2];
18            for (int i = n - 1; i >= 0; i--) {
19                char ch = s.charAt(i);
20                // Suffix Array Construction
21                suf[i][0] =
22                    (i == n - 1 ? 0 : suf[i + 1][1]) + (ch == '1' ? 1 : 0);
23                suf[i][1] =
24                    (i == n - 1 ? 0 : suf[i + 1][0]) + (ch == '0' ? 1 : 0);
25            }
26
27            // Traverse all split points
28            for (int i = 0; i < n - 1; i++) {
29                ans = Math.min(ans, pre[i][0] + suf[i + 1][0]);
30                ans = Math.min(ans, pre[i][1] + suf[i + 1][1]);
31            }
32        }
33
34        return ans;
35    }
36}