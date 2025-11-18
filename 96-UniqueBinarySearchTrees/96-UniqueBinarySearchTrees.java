// Last updated: 11/18/2025, 11:38:28 PM
class Solution {
    public int numTrees(int n) {
        long res = 1;
        for (int i = 0; i < n; i++) {
            res = res * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) res;
    }
}
