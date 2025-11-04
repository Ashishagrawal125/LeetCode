// Last updated: 11/4/2025, 11:13:35 PM
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length, sum = 0, f = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += sum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }
}
