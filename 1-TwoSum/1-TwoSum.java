// Last updated: 8/27/2025, 12:55:08 PM
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement needed to reach the target
            int complement = target - nums[i];
            
            // Check if the complement is already in the map
            if (map.containsKey(complement)) {
                // Return the indices of the two numbers
                return new int[] { map.get(complement), i };
            }
            
            // Add the current number and its index to the map
            map.put(nums[i], i);
        }
        
        // Throw an exception if no solution is found
        throw new IllegalArgumentException("No two sum solution");
    }
}
