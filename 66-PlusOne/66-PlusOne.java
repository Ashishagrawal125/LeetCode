// Last updated: 8/27/2025, 12:54:21 PM
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newArray = new int[n + 1];
        newArray[0] = 1;
        return newArray;
    }
}
