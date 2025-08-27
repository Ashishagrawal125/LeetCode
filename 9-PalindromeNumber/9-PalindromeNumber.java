// Last updated: 8/27/2025, 12:54:59 PM
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int reverse = 0;
        while (x > 0) {
            int lastDigit = x % 10;
            reverse = reverse * 10 + lastDigit;
            x /= 10;
        }
        return temp == reverse;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        }
}