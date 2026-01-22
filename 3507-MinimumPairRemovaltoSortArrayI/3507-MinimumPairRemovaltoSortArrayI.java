// Last updated: 1/22/2026, 9:49:59 PM
1class Solution {
2
3    public int minimumPairRemoval(int[] nums) {
4        List<Integer> list = new ArrayList<>();
5        for (int num : nums) {
6            list.add(num);
7        }
8        var count = 0;
9
10        while (list.size() > 1) {
11            var isAscending = true;
12            var minSum = Integer.MAX_VALUE;
13            var targetIndex = -1;
14
15            for (var i = 0; i < list.size() - 1; i++) {
16                var sum = list.get(i) + list.get(i + 1);
17
18                if (list.get(i) > list.get(i + 1)) {
19                    isAscending = false;
20                }
21
22                if (sum < minSum) {
23                    minSum = sum;
24                    targetIndex = i;
25                }
26            }
27
28            if (isAscending) {
29                break;
30            }
31
32            count++;
33            list.set(targetIndex, minSum);
34            list.remove(targetIndex + 1);
35        }
36
37        return count;
38    }
39}