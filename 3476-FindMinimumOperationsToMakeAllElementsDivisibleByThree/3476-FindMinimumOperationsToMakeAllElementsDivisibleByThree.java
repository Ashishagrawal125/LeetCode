// Last updated: 4/14/2026, 4:42:39 PM
class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int x : nums) {
            if (x % 3 != 0) count++;
        }
        return count;
    }
}
