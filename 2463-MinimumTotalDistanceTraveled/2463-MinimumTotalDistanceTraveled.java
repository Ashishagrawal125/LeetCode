// Last updated: 4/14/2026, 4:42:46 PM
1class Solution {
2
3    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
4        // Sort robots and factories by position
5        Collections.sort(robot);
6        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
7
8        // Flatten factory positions according to their capacities
9        List<Integer> factoryPositions = new ArrayList<>();
10        for (int[] f : factory) {
11            for (int i = 0; i < f[1]; i++) {
12                factoryPositions.add(f[0]);
13            }
14        }
15
16        int robotCount = robot.size();
17        int factoryCount = factoryPositions.size();
18        long[][] memo = new long[robotCount][factoryCount];
19        for (long[] row : memo) Arrays.fill(row, -1);
20
21        // Recursively calculate minimum total distance with memoization
22        return calculateMinDistance(0, 0, robot, factoryPositions, memo);
23    }
24
25    private long calculateMinDistance(
26        int robotIdx,
27        int factoryIdx,
28        List<Integer> robot,
29        List<Integer> factoryPositions,
30        long[][] memo
31    ) {
32        // All robots assigned
33        if (robotIdx == robot.size()) return 0;
34        // No factories left to assign
35        if (factoryIdx == factoryPositions.size()) return (long) 1e12;
36        // Check memo
37        if (memo[robotIdx][factoryIdx] != -1) return memo[robotIdx][factoryIdx];
38
39        // Option 1: Assign current robot to current factory
40        long assign =
41            Math.abs(robot.get(robotIdx) - factoryPositions.get(factoryIdx)) +
42            calculateMinDistance(
43                robotIdx + 1,
44                factoryIdx + 1,
45                robot,
46                factoryPositions,
47                memo
48            );
49
50        // Option 2: Skip current factory for the current robot
51        long skip = calculateMinDistance(
52            robotIdx,
53            factoryIdx + 1,
54            robot,
55            factoryPositions,
56            memo
57        );
58
59        // Take the minimum and store in memo
60        memo[robotIdx][factoryIdx] = Math.min(assign, skip);
61        return memo[robotIdx][factoryIdx];
62    }
63}