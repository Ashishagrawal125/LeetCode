// Last updated: 8/27/2025, 12:53:41 PM
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int number : nums) {
            result = result ^ number;
        }
        return result;
    }
}
