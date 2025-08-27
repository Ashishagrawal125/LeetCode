// Last updated: 8/27/2025, 12:54:07 PM
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 1;  // i tracks the position for the next valid element
        int count = 1;  // count tracks the frequency of the current number

        // Start from the second element (index 1) and iterate through the array
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                count++;  // Increment count if current element is same as previous
            } else {
                count = 1;  // Reset count if current element is different from previous
            }

            // If count is less than or equal to 2, we can place the element
            if (count <= 2) {
                nums[i] = nums[j];
                i++;  // Move to the next position for valid elements
            }
        }

        return i;  // i is the new length of the array
    }
}
