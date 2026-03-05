// Last updated: 3/5/2026, 5:25:37 PM
1class Solution {
2    public int minOperations(String s) {
3        int start0 = 0;
4        int start1 = 0;
5        
6        for (int i = 0; i < s.length(); i++) {
7            if (i % 2 == 0) {
8                if (s.charAt(i) == '0') {
9                    start1++;
10                } else {
11                    start0++;
12                }
13            } else {
14                if (s.charAt(i) == '1') {
15                    start1++;
16                } else {
17                    start0++;
18                }
19            }
20        }
21        
22        return Math.min(start0, start1);
23    }
24}