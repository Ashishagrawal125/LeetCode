// Last updated: 12/4/2025, 11:03:27 PM
1class Solution {
2    public int countCollisions(String directions) {
3        int n = directions.length();
4        int i = 0;
5        while (i < n && directions.charAt(i) == 'L') i++;
6        int j = n - 1;
7        while (j >= 0 && directions.charAt(j) == 'R') j--;
8        if (i > j) return 0;
9        int ans = 0;
10        for (int k = i; k <= j; k++) if (directions.charAt(k) != 'S') ans++;
11        return ans;
12    }
13}
14