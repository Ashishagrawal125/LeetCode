// Last updated: 3/11/2026, 11:03:17 PM
1class Solution {
2    public int bitwiseComplement(int n) {
3        if (n == 0) return 1;
4        int mask = n;
5        for (int i = 0; i <= 4; i++)
6            mask |= mask >> (1 << i);
7        return ~n & mask;
8    }
9}