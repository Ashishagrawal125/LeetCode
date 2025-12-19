// Last updated: 12/19/2025, 10:06:37 PM
1import java.util.*;
2
3class Solution {
4    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
5        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
6        boolean[] know = new boolean[n];
7        know[0] = true;
8        know[firstPerson] = true;
9        int i = 0;
10        while (i < meetings.length) {
11            int time = meetings[i][2];
12            Map<Integer, List<Integer>> graph = new HashMap<>();
13            Set<Integer> people = new HashSet<>();
14            while (i < meetings.length && meetings[i][2] == time) {
15                int a = meetings[i][0], b = meetings[i][1];
16                graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
17                graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
18                people.add(a);
19                people.add(b);
20                i++;
21            }
22            Queue<Integer> q = new LinkedList<>();
23            Set<Integer> visited = new HashSet<>();
24            for (int p : people) {
25                if (know[p]) {
26                    q.offer(p);
27                    visited.add(p);
28                }
29            }
30            while (!q.isEmpty()) {
31                int cur = q.poll();
32                know[cur] = true;
33                if (!graph.containsKey(cur)) continue;
34                for (int nxt : graph.get(cur)) {
35                    if (!visited.contains(nxt)) {
36                        visited.add(nxt);
37                        q.offer(nxt);
38                    }
39                }
40            }
41        }
42        List<Integer> res = new ArrayList<>();
43        for (int j = 0; j < n; j++) {
44            if (know[j]) res.add(j);
45        }
46        return res;
47    }
48}
49