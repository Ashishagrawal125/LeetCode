// Last updated: 11/24/2025, 11:39:25 PM
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int mod = 0;
        for (int bit : nums) {
            mod = ((mod << 1) + bit) % 5;
            result.add(mod == 0);
        }
        return result;
    }
}
