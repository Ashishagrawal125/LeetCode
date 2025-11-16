// Last updated: 11/16/2025, 11:51:51 PM
class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0, b = (long) Math.sqrt(c);
        
        while (a <= b) {
            long sum = a * a + b * b;
            if (sum == c) return true;
            if (sum < c) a++;
            else b--;
        }
        
        return false;
    }
}
