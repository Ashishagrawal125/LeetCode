// Last updated: 12/11/2025, 4:48:48 PM
1import java.util.*;
2
3public class Solution {
4    public int countCoveredBuildings(int n, int[][] buildings) {
5        Map<Integer, List<Integer>> rows = new HashMap<>();
6        Map<Integer, List<Integer>> cols = new HashMap<>();
7        for (int[] b : buildings) {
8            int x = b[0], y = b[1];
9            rows.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
10            cols.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
11        }
12        for (List<Integer> list : rows.values()) Collections.sort(list);
13        for (List<Integer> list : cols.values()) Collections.sort(list);
14        int ans = 0;
15        for (int[] b : buildings) {
16            int x = b[0], y = b[1];
17            List<Integer> r = rows.get(x);
18            List<Integer> c = cols.get(y);
19            if (r.get(0) < y && r.get(r.size() - 1) > y && c.get(0) < x && c.get(c.size() - 1) > x) ans++;
20        }
21        return ans;
22    }
23}
24