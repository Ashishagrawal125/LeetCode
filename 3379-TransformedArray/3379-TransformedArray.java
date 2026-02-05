// Last updated: 2/5/2026, 9:56:30 PM
1class Solution {
2
3    public int[] constructTransformedArray(int[] nums) {
4        int n = nums.length;
5        int[] res = new int[n];
6        for (int i = 0; i < n; i++) {
7            res[i] = nums[(((i + nums[i]) % n) + n) % n];
8        }
9        return res;
10    }
11}