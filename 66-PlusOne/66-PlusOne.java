// Last updated: 1/1/2026, 11:18:00 PM
1class Solution {
2    public int[] plusOne(int[] digits) {
3        for(int i = digits.length - 1; i >= 0; i--) {
4            if(digits[i] != 9) {
5                digits[i] += 1;
6                return digits;
7            }
8            digits[i] = 0;
9        }   
10        digits = new int[digits.length + 1];
11        digits[0] = 1;
12        return digits;
13    }
14}