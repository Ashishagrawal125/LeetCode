// Last updated: 3/4/2026, 11:20:49 PM
1class Solution {
2    public int numSpecial(int[][] mat) {
3        int ans = 0;
4        int m = mat.length;
5        int n = mat[0].length;
6        
7        for (int row = 0; row < m; row++) {
8            for (int col = 0; col < n; col++) {
9                if (mat[row][col] == 0) {
10                    continue;
11                }
12                
13                boolean good = true;
14                for (int r = 0; r < m; r++) {
15                    if (r != row && mat[r][col] == 1) {
16                        good = false;
17                        break;
18                    }
19                }
20                
21                for (int c = 0; c < n; c++) {
22                    if (c != col && mat[row][c] == 1) {
23                        good = false;
24                        break;
25                    }
26                }
27                
28                if (good) {
29                    ans++;
30                }
31            }
32        }
33        
34        return ans;
35    }
36}