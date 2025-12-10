// Last updated: 12/10/2025, 11:05:25 PM
1class Solution {
2    public int countPermutations(int[] complexity) {
3        final int MOD = 1_000_000_007;
4        long result = 1;
5        for (int i = 1; i < complexity.length; i++) {
6            if (complexity[i] <= complexity[0]) {
7                return 0;
8            }
9            result = (result * i) % MOD;
10        }
11        return (int) result;
12    }
13}
14