// Last updated: 8/27/2025, 12:54:38 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        CoinCombination(candidates, target, ll, ans, 0);
        return ans;
    }

    public void CoinCombination(int[] coin, int amount, List<Integer> ll, List<List<Integer>> ans, int idx) {
        // Base case: if the amount is 0, add the current combination to the result
        if (amount == 0) {
            ans.add(new ArrayList<>(ll));  // Copy current list to avoid reference issues
            return;
        }

        // Iterate through the candidates starting from idx
        for (int i = idx; i < coin.length; i++) {
            // Skip if the candidate is greater than the remaining amount
            if (amount < coin[i]) {
                continue;
            }

            // Choose the current coin
            ll.add(coin[i]);
            // Recurse with reduced amount and the same index (for reusing the same coin)
            CoinCombination(coin, amount - coin[i], ll, ans, i);
            // Backtrack by removing the last coin added
            ll.remove(ll.size() - 1);
        }
    }
}
