// Last updated: 1/29/2026, 1:06:44 PM
1class Solution {
2
3    public long minimumCost(
4        String source,
5        String target,
6        char[] original,
7        char[] changed,
8        int[] cost
9    ) {
10        // Create a graph representation of character conversions
11        List<int[]>[] adjacencyList = new List[26];
12        for (int i = 0; i < 26; i++) {
13            adjacencyList[i] = new ArrayList<>();
14        }
15
16        // Populate the adjacency list with character conversions
17        int conversionCount = original.length;
18        for (int i = 0; i < conversionCount; i++) {
19            adjacencyList[original[i] - 'a'].add(
20                    new int[] { changed[i] - 'a', cost[i] }
21                );
22        }
23
24        // Calculate shortest paths for all possible character conversions
25        long[][] minConversionCosts = new long[26][26];
26        for (int i = 0; i < 26; i++) {
27            minConversionCosts[i] = dijkstra(i, adjacencyList);
28        }
29
30        // Calculate the total cost of converting source to target
31        long totalCost = 0;
32        int stringLength = source.length();
33        for (int i = 0; i < stringLength; i++) {
34            if (source.charAt(i) != target.charAt(i)) {
35                long charConversionCost =
36                    minConversionCosts[source.charAt(i) - 'a'][target.charAt(
37                            i
38                        ) -
39                        'a'];
40                if (charConversionCost == -1) {
41                    return -1; // Conversion not possible
42                }
43                totalCost += charConversionCost;
44            }
45        }
46        return totalCost;
47    }
48
49    // Find minimum conversion costs from a starting character to all other characters
50    private long[] dijkstra(int startChar, List<int[]>[] adjacencyList) {
51        // Priority queue to store characters with their conversion cost, sorted by cost
52        PriorityQueue<Pair<Long, Integer>> priorityQueue = new PriorityQueue<>(
53            (e1, e2) -> Long.compare(e1.getKey(), e2.getKey())
54        );
55
56        // Initialize the starting character with cost 0
57        priorityQueue.add(new Pair<>(0L, startChar));
58
59        // Array to store the minimum conversion cost to each character
60        long[] minCosts = new long[26];
61        // Initialize all costs to -1 (unreachable)
62        Arrays.fill(minCosts, -1L);
63
64        while (!priorityQueue.isEmpty()) {
65            Pair<Long, Integer> currentPair = priorityQueue.poll();
66            long currentCost = currentPair.getKey();
67            int currentChar = currentPair.getValue();
68
69            if (
70                minCosts[currentChar] != -1L &&
71                minCosts[currentChar] < currentCost
72            ) continue;
73
74            // Explore all possible conversions from the current character
75            for (int[] conversion : adjacencyList[currentChar]) {
76                int targetChar = conversion[0];
77                long conversionCost = conversion[1];
78                long newTotalCost = currentCost + conversionCost;
79
80                // If we found a cheaper conversion, update its cost
81                if (
82                    minCosts[targetChar] == -1L ||
83                    newTotalCost < minCosts[targetChar]
84                ) {
85                    minCosts[targetChar] = newTotalCost;
86                    // Add the updated conversion to the queue for further exploration
87                    priorityQueue.add(new Pair<>(newTotalCost, targetChar));
88                }
89            }
90        }
91        // Return the array of minimum conversion costs from the starting character to all others
92        return minCosts;
93    }
94}