// Last updated: 8/27/2025, 12:55:00 PM
class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            // Extract the last digit
            int digit = x % 10;
            x /= 10;

            // Check for overflow/underflow before updating result
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Overflow
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Underflow
            }

            // Update result
            result = result * 10 + digit;
        }

        return result;
    }
}
