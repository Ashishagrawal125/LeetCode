// Last updated: 4/14/2026, 4:43:15 PM
import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        boolean[] know = new boolean[n];
        know[0] = true;
        know[firstPerson] = true;
        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> people = new HashSet<>();
            while (i < meetings.length && meetings[i][2] == time) {
                int a = meetings[i][0], b = meetings[i][1];
                graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
                people.add(a);
                people.add(b);
                i++;
            }
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            for (int p : people) {
                if (know[p]) {
                    q.offer(p);
                    visited.add(p);
                }
            }
            while (!q.isEmpty()) {
                int cur = q.poll();
                know[cur] = true;
                if (!graph.containsKey(cur)) continue;
                for (int nxt : graph.get(cur)) {
                    if (!visited.contains(nxt)) {
                        visited.add(nxt);
                        q.offer(nxt);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (know[j]) res.add(j);
        }
        return res;
    }
}
