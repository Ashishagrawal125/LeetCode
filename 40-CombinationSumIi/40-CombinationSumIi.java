// Last updated: 8/27/2025, 12:54:37 PM
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates easily
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination)); // Found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // If the current candidate exceeds the target, no need to continue
            if (candidates[i] > target) break;

            // Include the current candidate
            combination.add(candidates[i]);

            // Recur with reduced target and next start index
            backtrack(candidates, target - candidates[i], i + 1, combination, result);

            // Backtrack
            combination.remove(combination.size() - 1);
        }
    }
}
