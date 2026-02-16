// Last updated: 2/16/2026, 1:31:58 PM
1class Solution {
2    public int reverseBits(int n) { return rev(n, 32); }
3
4    private int rev(int v, int len) {
5        if (len == 1) return v & 1;
6
7        int half = len >> 1;
8        int mask = (1 << half) - 1;
9        int lo = v & mask;
10        int hi = v >>> half;
11
12        return (rev(lo, half) << half) | rev(hi, half);
13    }
14}
15