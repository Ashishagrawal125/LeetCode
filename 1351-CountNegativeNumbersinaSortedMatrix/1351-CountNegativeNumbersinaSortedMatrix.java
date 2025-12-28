// Last updated: 12/28/2025, 8:21:58 PM
1class Solution {
2    public int countNegatives(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        int i = m - 1, j = 0;
5
6        int res = 0;
7
8        while (i >= 0 && j < n) {
9            if (grid[i][j] < 0) {
10                res += n - j;
11                i--;
12            } else
13                j++;
14        }
15
16        return res;
17    }
18}
19