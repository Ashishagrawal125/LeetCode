// Last updated: 12/26/2025, 8:48:57 AM
1class Solution {
2
3    public int bestClosingTime(String customers) {
4        int curPenalty = 0;
5        for (int i = 0; i < customers.length(); i++) {
6            if (customers.charAt(i) == 'Y') {
7                curPenalty++;
8            }
9        }
10
11        // Start with closing at hour 0, the penalty equals all 'Y' in closed hours.
12        int minPenalty = curPenalty;
13        int earliestHour = 0;
14
15        for (int i = 0; i < customers.length(); i++) {
16            char ch = customers.charAt(i);
17
18            // If status in hour i is 'Y', moving it to open hours decrement
19            // penalty by 1. Otherwise, moving 'N' to open hours increment
20            // penatly by 1.
21            if (ch == 'Y') {
22                curPenalty--;
23            } else {
24                curPenalty++;
25            }
26
27            // Update earliestHour if a smaller penatly is encountered.
28            if (curPenalty < minPenalty) {
29                earliestHour = i + 1;
30                minPenalty = curPenalty;
31            }
32        }
33
34        return earliestHour;
35    }
36}