// Last updated: 8/27/2025, 12:54:18 PM
public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x; // Base cases: sqrt(0) = 0, sqrt(1) = 1
        }
        
        int left = 0, right = x;
        
        // Binary search for the integer square root
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSquare = (long) mid * mid; // To avoid overflow
            
            if (midSquare == x) {
                return mid; // Found the exact square root
            } else if (midSquare < x) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }
        
        // When the loop ends, `right` is the largest integer whose square is <= x
        return right;
    }
}
