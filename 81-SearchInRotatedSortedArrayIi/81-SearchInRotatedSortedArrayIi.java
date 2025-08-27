// Last updated: 8/27/2025, 12:54:05 PM
public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is found
            if (nums[mid] == target) {
                return true;
            }

            // If we cannot determine which part is sorted (due to duplicates), shrink the search space
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) { // Left part is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left part
                } else {
                    left = mid + 1; // Target is in the right part
                }
            } else { // Right part is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right part
                } else {
                    right = mid - 1; // Target is in the left part
                }
            }
        }

        return false; // Target not found
    }
}
