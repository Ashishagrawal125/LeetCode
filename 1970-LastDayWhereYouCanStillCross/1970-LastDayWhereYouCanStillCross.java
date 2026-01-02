// Last updated: 1/2/2026, 11:36:38 PM
1class Solution {
2    public int latestDayToCross(int row, int col, int[][] cells) {
3        DSU dsu = new DSU(row * col + 2);
4        int[][] grid = new int[row][col];
5        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
6
7        for (int i = cells.length - 1; i >= 0; i--) {
8            int r = cells[i][0] - 1;
9            int c = cells[i][1] - 1;
10            grid[r][c] = 1;
11
12            int id1 = r * col + c + 1;
13
14            for (int[] d : dirs) {
15                int nr = r + d[0];
16                int nc = c + d[1];
17                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1)
18                    dsu.union(id1, nr * col + nc + 1);
19            }
20
21            if (r == 0)
22                dsu.union(0, id1);
23
24            if (r == row - 1)
25                dsu.union(row * col + 1, id1);
26
27            if (dsu.find(0) == dsu.find(row * col + 1))
28                return i;
29        }
30
31        return -1;
32    }
33}
34
35class DSU {
36    int[] root;
37    int[] size;
38
39    DSU(int n) {
40        root = new int[n];
41        size = new int[n];
42        for (int i = 0; i < n; i++)
43            root[i] = i;
44        Arrays.fill(size, 1);
45    }
46
47    int find(int x) {
48        if (root[x] != x)
49            root[x] = find(root[x]);
50        return root[x];
51    }
52
53    void union(int x, int y) {
54        int rx = find(x);
55        int ry = find(y);
56
57        if (rx == ry)
58            return;
59
60        if (size[rx] > size[ry]) {
61            int tmp = rx;
62            rx = ry;
63            ry = tmp;
64        }
65
66        root[rx] = ry;
67        size[ry] += size[rx];
68    }
69}