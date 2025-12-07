// Last updated: 12/7/2025, 10:59:38 PM
1class Solution {
2    public int countOdds(int low, int high) {
3        int total = high - low + 1;
4        if ((low & 1) == 1 && (high & 1) == 1) return total / 2 + 1;
5        return total / 2;
6    }
7}
8