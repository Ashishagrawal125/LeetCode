// Last updated: 12/25/2025, 9:55:42 PM
1class Solution {
2
3    public int minimumBoxes(int[] apple, int[] capacity) {
4        int sum = 0;
5        for (int a : apple) {
6            sum += a;
7        }
8
9        Integer[] capArray = new Integer[capacity.length];
10        for (int i = 0; i < capacity.length; i++) {
11            capArray[i] = capacity[i];
12        }
13
14        Arrays.sort(capArray, Collections.reverseOrder());
15
16        int need = 0;
17        while (sum > 0) {
18            sum -= capArray[need];
19            need += 1;
20        }
21
22        return need;
23    }
24}