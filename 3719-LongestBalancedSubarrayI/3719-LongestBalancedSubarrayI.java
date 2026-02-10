// Last updated: 2/10/2026, 11:11:51 PM
1class Solution {
2
3    public int longestBalanced(int[] nums) {
4        int len = 0;
5
6        for (int i = 0; i < nums.length; i++) {
7            HashMap<Integer, Integer> odd = new HashMap<>();
8            HashMap<Integer, Integer> even = new HashMap<>();
9
10            for (int j = i; j < nums.length; j++) {
11                HashMap<Integer, Integer> map = (nums[j] & 1) == 1 ? odd : even;
12                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
13
14                if (odd.size() == even.size()) {
15                    len = Math.max(len, j - i + 1);
16                }
17            }
18        }
19
20        return len;
21    }
22}