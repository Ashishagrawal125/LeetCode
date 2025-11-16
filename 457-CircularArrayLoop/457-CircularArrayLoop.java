// Last updated: 11/16/2025, 11:51:15 PM
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i, fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                slow = next(nums, forward, slow);
                if (slow == -1) break;

                fast = next(nums, forward, fast);
                if (fast == -1) break;
                fast = next(nums, forward, fast);
                if (fast == -1) break;

                if (slow == fast) return true;
            }

            slow = i;
            int val = nums[i];
            while (nums[slow] * val > 0) {
                int nextIndex = ((slow + nums[slow]) % n + n) % n;
                nums[slow] = 0;
                slow = nextIndex;
            }
        }

        return false;
    }

    private int next(int[] nums, boolean forward, int index) {
        int n = nums.length;
        boolean direction = nums[index] > 0;
        if (direction != forward) return -1;

        int next = ((index + nums[index]) % n + n) % n;
        if (next == index) return -1;

        return next;
    }
}
