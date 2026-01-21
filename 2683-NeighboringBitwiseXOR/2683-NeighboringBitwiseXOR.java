// Last updated: 1/21/2026, 11:34:25 AM
1class Solution {
2    public boolean doesValidArrayExist(int[] derived) {
3        int xor=0;
4        for(int v : derived){
5            xor ^= v; 
6        }
7        return xor ==0;
8    }
9}