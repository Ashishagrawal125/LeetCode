// Last updated: 1/2/2026, 11:37:22 PM
1class Solution {
2    public int repeatedNTimes(int[] A) {
3        Map<Integer, Integer> count = new HashMap();
4        for (int x: A) {
5            count.put(x, count.getOrDefault(x, 0) + 1);
6        }
7
8        for (int k: count.keySet())
9            if (count.get(k) > 1)
10                return k;
11
12        throw null;
13    }
14}