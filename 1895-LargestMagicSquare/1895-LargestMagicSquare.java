// Last updated: 1/18/2026, 3:43:46 PM
1class Solution {
2
3    public int largestMagicSquare(int[][] grid) {
4        int m = grid.length;
5        int n = grid[0].length;
6        // prefix sum of each row
7        int[][] rowsum = new int[m][n];
8        for (int i = 0; i < m; ++i) {
9            rowsum[i][0] = grid[i][0];
10            for (int j = 1; j < n; ++j) {
11                rowsum[i][j] = rowsum[i][j - 1] + grid[i][j];
12            }
13        }
14        // prefix sum of each column
15        int[][] colsum = new int[m][n];
16        for (int j = 0; j < n; ++j) {
17            colsum[0][j] = grid[0][j];
18            for (int i = 1; i < m; ++i) {
19                colsum[i][j] = colsum[i - 1][j] + grid[i][j];
20            }
21        }
22
23        // enumerate edge lengths from largest to smallest
24        for (int edge = Math.min(m, n); edge >= 2; --edge) {
25            // enumerate the top-left corner position (i,j) of the square
26            for (int i = 0; i + edge <= m; ++i) {
27                for (int j = 0; j + edge <= n; ++j) {
28                    // the value for each row, column, and diagonal should be calculated (using the first row as a sample)
29                    int stdsum =
30                        rowsum[i][j + edge - 1] -
31                        (j > 0 ? rowsum[i][j - 1] : 0);
32                    boolean check = true;
33                    // enumerate each row and directly compute the sum using prefix sums
34                    for (int ii = i + 1; ii < i + edge; ++ii) {
35                        if (
36                            rowsum[ii][j + edge - 1] -
37                                (j > 0 ? rowsum[ii][j - 1] : 0) !=
38                            stdsum
39                        ) {
40                            check = false;
41                            break;
42                        }
43                    }
44                    if (!check) continue;
45                    // enumerate each column and directly calculate the sum using prefix sums
46                    for (int jj = j; jj < j + edge; ++jj) {
47                        if (
48                            colsum[i + edge - 1][jj] -
49                                (i > 0 ? colsum[i - 1][jj] : 0) !=
50                            stdsum
51                        ) {
52                            check = false;
53                            break;
54                        }
55                    }
56                    if (!check) continue;
57                    // 两条对角线的和
58                    int d1 = 0;
59                    int d2 = 0;
60                    for (int k = 0; k < edge; ++k) {
61                        d1 += grid[i + k][j + k];
62                        d2 += grid[i + k][j + edge - 1 - k];
63                    }
64                    if (d1 == stdsum && d2 == stdsum) {
65                        return edge;
66                    }
67                }
68            }
69        }
70        return 1;
71    }
72}