// Last updated: 4/16/2026, 11:26:00 PM
1class Solution {
2
3    public List<Integer> solveQueries(int[] nums, int[] queries) {
4        int n = nums.length;
5        HashMap<Integer, ArrayList<Integer>> numsPos = new HashMap<>();
6        for (int i = 0; i < n; i++) {
7            numsPos.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
8        }
9        for (ArrayList<Integer> pos : numsPos.values()) {
10            int x = pos.get(0);
11            int last = pos.get(pos.size() - 1);
12            pos.add(0, last - n);
13            pos.add(x + n);
14        }
15        List<Integer> result = new ArrayList<>();
16        for (int q : queries) {
17            int x = nums[q];
18            ArrayList<Integer> posList = numsPos.get(x);
19
20            if (posList.size() == 3) {
21                result.add(-1);
22                continue;
23            }
24
25            int idx = Collections.binarySearch(posList, q);
26            if (idx < 0) idx = -idx - 1;
27
28            int dist = Math.min(
29                posList.get(idx + 1) - posList.get(idx),
30                posList.get(idx) - posList.get(idx - 1)
31            );
32            result.add(dist);
33        }
34        return result;
35    }
36}