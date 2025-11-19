// Last updated: 11/19/2025, 7:10:51 PM
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] counts = new int[n + 1];
        for (int c : citations) {
            if (c >= n) counts[n]++;
            else counts[c]++;
        }
        int papers = 0;
        for (int h = n; h >= 0; h--) {
            papers += counts[h];
            if (papers >= h) return h;
        }
        return 0;
    }
}
