// Last updated: 4/14/2026, 4:43:47 PM
class Solution {
    public int countOdds(int low, int high) {
        int total = high - low + 1;
        if ((low & 1) == 1 && (high & 1) == 1) return total / 2 + 1;
        return total / 2;
    }
}
