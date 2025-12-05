// Last updated: 12/5/2025, 10:14:59 AM
1class Solution {
2    public int countPartitions(int[] nums) {
3        long sum = 0;
4        for (int x : nums) sum += x;
5        if ((sum & 1) == 1) return 0;
6        return nums.length - 1;
7    }
8}
9