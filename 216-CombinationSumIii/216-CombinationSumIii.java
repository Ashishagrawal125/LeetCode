// Last updated: 8/27/2025, 12:53:28 PM
import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int k, int remainingSum, int start, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k && remainingSum == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > remainingSum) break; // No need to continue if current number exceeds the remaining sum
            path.add(i);
            backtrack(k, remainingSum - i, i + 1, path, result);
            path.remove(path.size() - 1); // Backtrack
        }
    }
}
