// Last updated: 8/27/2025, 12:54:34 PM
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int jumps = 0; // Number of jumps
        int currentEnd = 0; // The end of the current jump range
        int farthest = 0; // The farthest point that can be reached with the next jump

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point that can be reached
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If the current end can reach or exceed the last index, we can stop
                if (currentEnd >= nums.length - 1) break;
            }
        }

        return jumps;
    }
}
