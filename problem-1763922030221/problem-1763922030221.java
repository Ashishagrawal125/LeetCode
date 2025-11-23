// Last updated: 11/23/2025, 11:50:30 PM
class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int[] r1 = {10001, 10001};
        int[] r2 = {10001, 10001};
        for (int x : nums) {
            sum += x;
            int m = x % 3;
            if (m == 1) {
                if (x < r1[0]) {
                    r1[1] = r1[0];
                    r1[0] = x;
                } else if (x < r1[1]) {
                    r1[1] = x;
                }
            } else if (m == 2) {
                if (x < r2[0]) {
                    r2[1] = r2[0];
                    r2[0] = x;
                } else if (x < r2[1]) {
                    r2[1] = x;
                }
            }
        }
        int mod = sum % 3;
        if (mod == 0) return sum;
        if (mod == 1) {
            int remove1 = r1[0];
            int remove2 = r2[0] + r2[1];
            int remove = Math.min(remove1, remove2);
            if (remove >= 10001) return 0;
            return sum - remove;
        } else {
            int remove1 = r2[0];
            int remove2 = r1[0] + r1[1];
            int remove = Math.min(remove1, remove2);
            if (remove >= 10001) return 0;
            return sum - remove;
        }
    }
}
