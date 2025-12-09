// Last updated: 12/9/2025, 12:09:29 PM
1import java.util.*;
2
3class Solution {
4    public int specialTriplets(int[] nums) {
5        Map<Integer, Integer> left = new HashMap<>();
6        Map<Integer, Integer> right = new HashMap<>();
7        for (int x : nums) {
8            right.put(x, right.getOrDefault(x, 0) + 1);
9        }
10        long ans = 0;
11        int mod = 1000000007;
12        for (int x : nums) {
13            right.put(x, right.get(x) - 1);
14            int l = left.getOrDefault(x * 2, 0);
15            int r = right.getOrDefault(x * 2, 0);
16            ans = (ans + (long) l * r) % mod;
17            left.put(x, left.getOrDefault(x, 0) + 1);
18        }
19        return (int) ans;
20    }
21}
22