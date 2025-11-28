// Last updated: 11/28/2025, 9:14:54 PM
1class Solution {
2    private int ans;
3    private List<Integer>[] g;
4    private int k;
5    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
6        this.ans = 0;
7        this.k = k;
8        g = new ArrayList[n];
9        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
10        for (int[] e : edges) {
11            g[e[0]].add(e[1]);
12            g[e[1]].add(e[0]);
13        }
14        dfs(0, -1, values);
15        return ans;
16    }
17    private long dfs(int u, int p, int[] values) {
18        long sum = values[u];
19        for (int v : g[u]) {
20            if (v == p) continue;
21            sum += dfs(v, u, values);
22        }
23        if (sum % k == 0) {
24            ans++;
25            return 0;
26        }
27        return sum;
28    }
29}
30