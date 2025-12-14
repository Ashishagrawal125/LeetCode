// Last updated: 12/14/2025, 5:43:46 PM
1class Solution {
2    public int numberOfWays(String corridor) {
3        long mod = 1000000007;
4        int seats = 0;
5        for (int i = 0; i < corridor.length(); i++) {
6            if (corridor.charAt(i) == 'S') seats++;
7        }
8        if (seats == 0 || seats % 2 == 1) return 0;
9
10        long ways = 1;
11        int countS = 0;
12        int plants = 0;
13
14        for (int i = 0; i < corridor.length(); i++) {
15            char c = corridor.charAt(i);
16            if (c == 'S') {
17                countS++;
18                if (countS > 2 && countS % 2 == 1) {
19                    ways = (ways * (plants + 1)) % mod;
20                }
21                plants = 0;
22            } else if (countS >= 2 && countS % 2 == 0) {
23                plants++;
24            }
25        }
26        return (int) ways;
27    }
28}
29