// Last updated: 2/18/2026, 7:34:29 PM
1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        String s = Integer.toBinaryString(n);
4        for(int i=0; i<s.length()-1; i++){
5            if(s.charAt(i) == s.charAt(i+1)) return false;
6        }
7        return true;    
8    }
9}