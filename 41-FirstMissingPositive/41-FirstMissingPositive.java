// Last updated: 9/19/2025, 10:43:15 PM
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n1 = 0, n2 = 0, c1 = 0, c2 = 0;
        for (int num : nums) {
            if (num == n1) c1++;
            else if (num == n2) c2++;
            else if (c1 == 0) {
                n1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        c1 = c2 = 0;
        for (int num : nums) {
            if (num == n1) c1++;
            else if (num == n2) c2++;
        }
        if (c1 > nums.length / 3) res.add(n1);
        if (c2 > nums.length / 3) res.add(n2);
        return res;
    }
}
