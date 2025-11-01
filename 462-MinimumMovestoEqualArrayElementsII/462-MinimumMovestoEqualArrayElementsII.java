// Last updated: 11/1/2025, 10:50:21 PM
import java.util.*;
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = nums[n / 2];
        int moves = 0;
        for (int num : nums) moves += Math.abs(num - median);
        return moves;
    }
}
