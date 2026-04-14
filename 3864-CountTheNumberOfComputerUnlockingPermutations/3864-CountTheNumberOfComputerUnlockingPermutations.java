// Last updated: 4/14/2026, 4:42:14 PM
class Solution {
    public int countPermutations(int[] complexity) {
        final int MOD = 1_000_000_007;
        long result = 1;
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
            result = (result * i) % MOD;
        }
        return (int) result;
    }
}
