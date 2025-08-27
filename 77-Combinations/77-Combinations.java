// Last updated: 8/27/2025, 12:54:11 PM
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(result, currentCombination, n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination, int n, int k, int start) {
        // If the current combination has reached the desired length, add it to the result
        if (currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        
        // Try every possible number starting from 'start'
        for (int i = start; i <= n; i++) {
            // Add the number to the current combination
            currentCombination.add(i);
            
            // Recurse with the next number
            backtrack(result, currentCombination, n, k, i + 1);
            
            // Backtrack by removing the last number added
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
