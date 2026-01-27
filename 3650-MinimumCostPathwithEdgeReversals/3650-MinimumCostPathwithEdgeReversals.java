// Last updated: 1/27/2026, 7:48:12 PM
1class Solution {
2
3    public int minCost(int n, int[][] edges) {
4        List<int[]>[] g = new ArrayList[n];
5        for (int i = 0; i < n; i++) {
6            g[i] = new ArrayList<>();
7        }
8
9        for (int[] e : edges) {
10            int x = e[0];
11            int y = e[1];
12            int w = e[2];
13            g[x].add(new int[] { y, w });
14            g[y].add(new int[] { x, 2 * w });
15        }
16
17        // Dijkstra
18        int[] d = new int[n];
19        boolean[] visited = new boolean[n];
20        Arrays.fill(d, Integer.MAX_VALUE);
21        d[0] = 0;
22
23        PriorityQueue<int[]> pq = new PriorityQueue<>(
24            Comparator.comparingInt(a -> a[0])
25        );
26        pq.offer(new int[] { 0, 0 }); // [Distance, Node]
27
28        while (!pq.isEmpty()) {
29            int[] current = pq.poll();
30            int dist = current[0];
31            int x = current[1];
32
33            if (x == n - 1) {
34                return dist;
35            }
36
37            if (visited[x]) {
38                continue;
39            }
40            visited[x] = true;
41
42            for (int[] neighbor : g[x]) {
43                int y = neighbor[0];
44                int w = neighbor[1];
45
46                if (dist + w < d[y]) {
47                    d[y] = dist + w;
48                    pq.offer(new int[] { d[y], y });
49                }
50            }
51        }
52
53        return -1;
54    }
55}