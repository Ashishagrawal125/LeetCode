// Last updated: 8/27/2025, 12:53:04 PM
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
     int ans = 0;
        int start = 0;
        int end = 0;
        int product = 1;
        while(end < nums.length) {
            
            //grow
            product = product * nums[end];
            
            //shrink
            while(product >= k && start <= end) {
                product = product / nums[start];
                start++;
            }
            
            //update
            ans = ans + (end - start +1);
            end++;
        }
        return ans;   
    }
}