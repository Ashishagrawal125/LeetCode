// Last updated: 1/30/2026, 7:52:21 PM
1class Trie {
2
3    Trie[] child = new Trie[26];
4    int id = -1;
5}
6
7class Solution {
8
9    private static final int INF = Integer.MAX_VALUE / 2;
10
11    private int add(Trie node, String word, int[] index) {
12        for (char ch : word.toCharArray()) {
13            int i = ch - 'a';
14            if (node.child[i] == null) {
15                node.child[i] = new Trie();
16            }
17            node = node.child[i];
18        }
19        if (node.id == -1) {
20            node.id = ++index[0];
21        }
22        return node.id;
23    }
24
25    private void update(long[] x, long y) {
26        if (x[0] == -1 || y < x[0]) {
27            x[0] = y;
28        }
29    }
30
31    public long minimumCost(
32        String source,
33        String target,
34        String[] original,
35        String[] changed,
36        int[] cost
37    ) {
38        int n = source.length();
39        int m = original.length;
40        Trie root = new Trie();
41
42        int[] p = { -1 };
43        int[][] G = new int[m * 2][m * 2];
44
45        for (int i = 0; i < m * 2; i++) {
46            Arrays.fill(G[i], INF);
47            G[i][i] = 0;
48        }
49
50        for (int i = 0; i < m; i++) {
51            int x = add(root, original[i], p);
52            int y = add(root, changed[i], p);
53            G[x][y] = Math.min(G[x][y], cost[i]);
54        }
55
56        int size = p[0] + 1;
57        for (int k = 0; k < size; k++) {
58            for (int i = 0; i < size; i++) {
59                for (int j = 0; j < size; j++) {
60                    G[i][j] = Math.min(G[i][j], G[i][k] + G[k][j]);
61                }
62            }
63        }
64
65        long[] f = new long[n];
66        Arrays.fill(f, -1);
67        for (int j = 0; j < n; j++) {
68            if (j > 0 && f[j - 1] == -1) {
69                continue;
70            }
71            long base = (j == 0 ? 0 : f[j - 1]);
72            if (source.charAt(j) == target.charAt(j)) {
73                f[j] = f[j] == -1 ? base : Math.min(f[j], base);
74            }
75
76            Trie u = root;
77            Trie v = root;
78            for (int i = j; i < n; i++) {
79                u = u.child[source.charAt(i) - 'a'];
80                v = v.child[target.charAt(i) - 'a'];
81                if (u == null || v == null) {
82                    break;
83                }
84                if (u.id != -1 && v.id != -1 && G[u.id][v.id] != INF) {
85                    long newVal = base + G[u.id][v.id];
86                    if (f[i] == -1 || newVal < f[i]) {
87                        f[i] = newVal;
88                    }
89                }
90            }
91        }
92
93        return f[n - 1];
94    }
95}