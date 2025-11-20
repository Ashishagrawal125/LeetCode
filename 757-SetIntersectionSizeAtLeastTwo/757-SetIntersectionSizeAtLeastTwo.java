// Last updated: 11/20/2025, 11:49:21 PM
import java.util.*;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int a = intervals[0][1] - 1;
        int b = intervals[0][1];
        int count = 2;
        
        for (int i = 1; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (l <= a) continue;
            if (l <= b) {
                count++;
                a = b;
                b = r;
            } else {
                count += 2;
                a = r - 1;
                b = r;
            }
        }
        return count;
    }
}
