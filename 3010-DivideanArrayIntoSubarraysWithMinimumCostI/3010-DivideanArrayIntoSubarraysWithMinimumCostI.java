// Last updated: 2/1/2026, 7:22:19 PM
1class Solution {
2    public int minimumCost(int[] nums) {
3        int min1 = Integer.MAX_VALUE;
4        int min2 = Integer.MAX_VALUE;
5        
6        for (int i = 1; i < nums.length; i++) {
7            if (nums[i] < min1) {
8                min2 = min1;
9                min1 = nums[i];
10            } else if (nums[i] < min2) {
11                min2 = nums[i];
12            }
13        }
14        
15        return nums[0] + min1 + min2;
16    }
17}