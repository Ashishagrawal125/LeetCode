// Last updated: 4/14/2026, 4:43:03 PM
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor=0;
        for(int v : derived){
            xor ^= v; 
        }
        return xor ==0;
    }
}