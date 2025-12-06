// Last updated: 12/6/2025, 10:24:25 PM
1import java.util.*;
2
3class Solution {
4    public int countPartitions(int[] nums, int k) {
5        int n = nums.length;
6        int MOD = 1_000_000_007;
7        long[] dp = new long[n + 1];
8        dp[0] = 1;
9        Deque<Integer> minD = new ArrayDeque<>();
10        Deque<Integer> maxD = new ArrayDeque<>();
11        int left = 0;
12        long sum = 0;
13        for (int right = 0; right < n; right++) {
14            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[right]) minD.pollLast();
15            minD.offerLast(right);
16            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[right]) maxD.pollLast();
17            maxD.offerLast(right);
18            while (nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {
19                if (minD.peekFirst() == left) minD.pollFirst();
20                if (maxD.peekFirst() == left) maxD.pollFirst();
21                sum = (sum - dp[left] + MOD) % MOD;
22                left++;
23            }
24            sum = (sum + dp[right]) % MOD;
25            dp[right + 1] = sum;
26        }
27        return (int) dp[n];
28    }
29}
30