// Last updated: 8/27/2025, 12:54:33 PM
import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) continue; // skip if number already used
            tempList.add(nums[i]);
            backtrack(nums, tempList, result);
            tempList.remove(tempList.size() - 1); // backtrack
        }
    }
}
