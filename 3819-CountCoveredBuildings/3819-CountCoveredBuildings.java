// Last updated: 4/14/2026, 4:42:20 PM
import java.util.*;

public class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> cols = new HashMap<>();
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            rows.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            cols.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }
        for (List<Integer> list : rows.values()) Collections.sort(list);
        for (List<Integer> list : cols.values()) Collections.sort(list);
        int ans = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            List<Integer> r = rows.get(x);
            List<Integer> c = cols.get(y);
            if (r.get(0) < y && r.get(r.size() - 1) > y && c.get(0) < x && c.get(c.size() - 1) > x) ans++;
        }
        return ans;
    }
}
