// Last updated: 8/27/2025, 12:54:09 PM
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(result, currentSubset, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add the current subset to the result
        result.add(new ArrayList<>(currentSubset));
        
        // Recursively build the subset by adding one element at a time
        for (int i = start; i < nums.length; i++) {
            // Include the current element
            currentSubset.add(nums[i]);
            
            // Recurse with the next element
            backtrack(result, currentSubset, nums, i + 1);
            
            // Backtrack by removing the last element added
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
