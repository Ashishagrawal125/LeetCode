// Last updated: 2/6/2026, 8:57:45 PM
1class Solution {
2
3    public int minRemoval(int[] nums, int k) {
4        int n = nums.length;
5        Arrays.sort(nums);
6
7        int ans = n;
8        int right = 0;
9
10        for (int left = 0; left < n; left++) {
11            while (right < n && nums[right] <= (long) nums[left] * k) {
12                right++;
13            }
14            ans = Math.min(ans, n - (right - left));
15        }
16
17        return ans;
18    }
19}