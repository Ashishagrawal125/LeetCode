// Last updated: 8/27/2025, 12:54:12 PM
class Solution {
    public void sortColors(int[] nums) {
        int low = 0; // Pointer for 0s
        int high = nums.length - 1; // Pointer for 2s
        int i = 0; // Current index to be evaluated

        while (i <= high) {
            if (nums[i] == 0) {
                // Swap nums[i] with nums[low] and move both pointers
                swap(nums, i, low);
                low++;
                i++;
            } else if (nums[i] == 1) {
                // Move to the next element
                i++;
            } else if (nums[i] == 2) {
                // Swap nums[i] with nums[high] and move the high pointer
                swap(nums, i, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
