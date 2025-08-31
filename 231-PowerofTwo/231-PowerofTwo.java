// Last updated: 8/31/2025, 7:48:48 PM
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0; 
    }
}