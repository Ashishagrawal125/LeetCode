// Last updated: 4/14/2026, 4:42:12 PM
import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0) + 1);
        }
        long ans = 0;
        int mod = 1000000007;
        for (int x : nums) {
            right.put(x, right.get(x) - 1);
            int l = left.getOrDefault(x * 2, 0);
            int r = right.getOrDefault(x * 2, 0);
            ans = (ans + (long) l * r) % mod;
            left.put(x, left.getOrDefault(x, 0) + 1);
        }
        return (int) ans;
    }
}
