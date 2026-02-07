// Last updated: 2/7/2026, 8:55:11 PM
1class Solution {
2
3    public int minimumDeletions(String s) {
4        int n = s.length();
5        int[] countA = new int[n];
6        int[] countB = new int[n];
7        int bCount = 0;
8
9        // First pass: compute count_b which stores the number of
10        // 'b' characters to the left of the current position.
11        for (int i = 0; i < n; i++) {
12            countB[i] = bCount;
13            if (s.charAt(i) == 'b') bCount++;
14        }
15
16        int aCount = 0;
17        // Second pass: compute count_a which stores the number of
18        // 'a' characters to the right of the current position
19        for (int i = n - 1; i >= 0; i--) {
20            countA[i] = aCount;
21            if (s.charAt(i) == 'a') aCount++;
22        }
23
24        int minDeletions = n;
25        // Third pass: iterate through the string to find the minimum deletions
26        for (int i = 0; i < n; i++) {
27            minDeletions = Math.min(minDeletions, countA[i] + countB[i]);
28        }
29
30        return minDeletions;
31    }
32}