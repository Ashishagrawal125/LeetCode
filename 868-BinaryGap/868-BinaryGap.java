// Last updated: 2/22/2026, 10:14:04 PM
1class Solution {
2    public int binaryGap(int N) {
3        int[] A = new int[32];
4        int t = 0;
5        for (int i = 0; i < 32; ++i)
6            if (((N >> i) & 1) != 0)
7                A[t++] = i;
8
9        int ans = 0;
10        for (int i = 0; i < t - 1; ++i)
11            ans = Math.max(ans, A[i+1] - A[i]);
12        return ans;
13    }
14}