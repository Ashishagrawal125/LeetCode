// Last updated: 1/24/2026, 9:57:32 PM
1class Solution {
2  public int minPairSum(int[] nums) {
3    Arrays.sort(nums);
4
5    int maxSum = 0;
6    for (int i = 0; i < nums.length / 2; i++) {
7      maxSum = Math.max(maxSum, nums[i] + nums[nums.length - 1 - i]);
8    }
9
10    return maxSum;
11
12  }
13}