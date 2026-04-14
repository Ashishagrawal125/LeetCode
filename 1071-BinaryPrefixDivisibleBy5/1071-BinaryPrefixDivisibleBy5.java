// Last updated: 4/14/2026, 4:44:11 PM
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
