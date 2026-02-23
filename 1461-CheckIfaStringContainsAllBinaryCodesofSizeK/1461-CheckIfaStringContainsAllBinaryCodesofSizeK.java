// Last updated: 2/23/2026, 8:12:39 PM
1class Solution {
2    public boolean hasAllCodes(String s, int k) {
3        int req = 1 << k;
4        boolean[] seen = new boolean[req];
5        int mask = req - 1;
6        int hash = 0;
7
8        for (int i = 0; i < s.length(); ++i) {
9            hash = ((hash << 1) & mask) | (s.charAt(i) & 1);
10
11            if (i >= k - 1 && !seen[hash]) {
12                seen[hash] = true;
13                req--;
14                if (req == 0) return true;
15            }
16        }
17
18        return false;
19    }
20}