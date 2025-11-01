// Last updated: 11/1/2025, 10:49:05 PM
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0; 
    }
}