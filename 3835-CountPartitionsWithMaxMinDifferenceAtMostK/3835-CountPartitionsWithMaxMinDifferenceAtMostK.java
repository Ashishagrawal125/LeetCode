// Last updated: 4/14/2026, 4:42:19 PM
import java.util.*;

class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        Deque<Integer> minD = new ArrayDeque<>();
        Deque<Integer> maxD = new ArrayDeque<>();
        int left = 0;
        long sum = 0;
        for (int right = 0; right < n; right++) {
            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[right]) minD.pollLast();
            minD.offerLast(right);
            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[right]) maxD.pollLast();
            maxD.offerLast(right);
            while (nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {
                if (minD.peekFirst() == left) minD.pollFirst();
                if (maxD.peekFirst() == left) maxD.pollFirst();
                sum = (sum - dp[left] + MOD) % MOD;
                left++;
            }
            sum = (sum + dp[right]) % MOD;
            dp[right + 1] = sum;
        }
        return (int) dp[n];
    }
}
