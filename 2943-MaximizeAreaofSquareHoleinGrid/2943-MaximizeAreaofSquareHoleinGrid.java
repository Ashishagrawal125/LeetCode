// Last updated: 1/15/2026, 2:16:24 PM
1class Solution {
2
3    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
4        Arrays.sort(hBars);
5        Arrays.sort(vBars);
6        int hmax = 1;
7        int vmax = 1;
8        int hcur = 1;
9        int vcur = 1;
10        for (int i = 1; i < hBars.length; i++) {
11            if (hBars[i] == hBars[i - 1] + 1) {
12                hcur++;
13            } else {
14                hcur = 1;
15            }
16            hmax = Math.max(hmax, hcur);
17        }
18        for (int i = 1; i < vBars.length; i++) {
19            if (vBars[i] == vBars[i - 1] + 1) {
20                vcur++;
21            } else {
22                vcur = 1;
23            }
24            vmax = Math.max(vmax, vcur);
25        }
26        int side = Math.min(hmax, vmax) + 1;
27        return side * side;
28    }
29}