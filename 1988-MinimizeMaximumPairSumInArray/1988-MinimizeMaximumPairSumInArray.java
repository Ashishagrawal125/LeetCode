// Last updated: 4/14/2026, 4:43:31 PM
class Solution {
  public int minPairSum(int[] nums) {
    Arrays.sort(nums);

    int maxSum = 0;
    for (int i = 0; i < nums.length / 2; i++) {
      maxSum = Math.max(maxSum, nums[i] + nums[nums.length - 1 - i]);
    }

    return maxSum;

  }
}