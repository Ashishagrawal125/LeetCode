// Last updated: 8/27/2025, 12:54:47 PM
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // Pointer for the new array length
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
