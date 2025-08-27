// Last updated: 8/27/2025, 12:54:27 PM
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;  // The farthest index that can be reached

        for (int i = 0; i < nums.length; i++) {
            // If the current index is greater than maxReach, we can't move forward
            if (i > maxReach) {
                return false;
            }
            // Update maxReach to be the maximum of the current maxReach or the new reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
            // If maxReach has reached or exceeded the last index, we can jump to the end
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
