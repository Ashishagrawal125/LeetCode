// Last updated: 11/19/2025, 7:10:26 PM
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
