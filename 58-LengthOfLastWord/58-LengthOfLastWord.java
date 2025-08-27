// Last updated: 8/27/2025, 12:54:25 PM
class Solution {
    public int lengthOfLastWord(String s) {
     s = s.trim();
        int lastSpaceIndex = s.lastIndexOf(' ');
        return s.length() - lastSpaceIndex - 1;   
    }
}