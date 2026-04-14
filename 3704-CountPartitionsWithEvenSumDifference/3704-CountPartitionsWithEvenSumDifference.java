// Last updated: 4/14/2026, 4:42:29 PM
class Solution {
    public int countPartitions(int[] nums) {
        long sum = 0;
        for (int x : nums) sum += x;
        if ((sum & 1) == 1) return 0;
        return nums.length - 1;
    }
}
