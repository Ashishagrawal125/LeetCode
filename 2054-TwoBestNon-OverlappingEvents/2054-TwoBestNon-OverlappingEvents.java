// Last updated: 12/23/2025, 4:30:52 PM
1class Solution {
2
3    public int maxTwoEvents(int[][] events) {
4        Arrays.sort(events, (a, b) -> a[0] - b[0]);
5        int[][] dp = new int[events.length][3];
6        for (int[] d : dp) Arrays.fill(d, -1);
7        return findEvents(events, 0, 0, dp);
8    }
9
10    // Recursive function to find the greatest sum for the pairs.
11    int findEvents(int[][] events, int idx, int cnt, int[][] dp) {
12        if (cnt == 2 || idx >= events.length) return 0;
13        if (dp[idx][cnt] == -1) {
14            int end = events[idx][1];
15            int lo = idx + 1, hi = events.length - 1;
16            while (lo < hi) {
17                int mid = lo + ((hi - lo) >> 1);
18                if (events[mid][0] > end) hi = mid;
19                else lo = mid + 1;
20            }
21            int include =
22                events[idx][2] +
23                (lo < events.length && events[lo][0] > end
24                        ? findEvents(events, lo, cnt + 1, dp)
25                        : 0);
26            int exclude = findEvents(events, idx + 1, cnt, dp);
27            dp[idx][cnt] = Math.max(include, exclude);
28        }
29        return dp[idx][cnt];
30    }
31}