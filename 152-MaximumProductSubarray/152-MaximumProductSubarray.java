// Last updated: 11/14/2025, 11:39:54 PM
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
