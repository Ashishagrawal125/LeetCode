// Last updated: 1/23/2026, 9:31:56 PM
1class Node {
2
3    long value;
4    int left;
5    Node prev;
6    Node next;
7
8    Node(int value, int left) {
9        this.value = value;
10        this.left = left;
11    }
12}
13
14class PQItem implements Comparable<PQItem> {
15
16    Node first;
17    Node second;
18    long cost;
19
20    PQItem(Node first, Node second, long cost) {
21        this.first = first;
22        this.second = second;
23        this.cost = cost;
24    }
25
26    @Override
27    public int compareTo(PQItem other) {
28        if (this.cost == other.cost) {
29            return this.first.left - other.first.left;
30        }
31        return this.cost < other.cost ? -1 : 1;
32    }
33}
34
35public class Solution {
36
37    public int minimumPairRemoval(int[] nums) {
38        PriorityQueue<PQItem> pq = new PriorityQueue<>();
39        boolean[] merged = new boolean[nums.length];
40
41        int decreaseCount = 0;
42        int count = 0;
43        Node head = new Node(nums[0], 0);
44        Node current = head;
45
46        for (int i = 1; i < nums.length; i++) {
47            Node newNode = new Node(nums[i], i);
48            current.next = newNode;
49            newNode.prev = current;
50            pq.offer(
51                new PQItem(current, newNode, current.value + newNode.value)
52            );
53            if (nums[i - 1] > nums[i]) {
54                decreaseCount++;
55            }
56            current = newNode;
57        }
58
59        while (decreaseCount > 0) {
60            PQItem item = pq.poll();
61            Node first = item.first;
62            Node second = item.second;
63            long cost = item.cost;
64
65            if (
66                merged[first.left] ||
67                merged[second.left] ||
68                first.value + second.value != cost
69            ) {
70                continue;
71            }
72            count++;
73            if (first.value > second.value) {
74                decreaseCount--;
75            }
76
77            Node prevNode = first.prev;
78            Node nextNode = second.next;
79            first.next = nextNode;
80            if (nextNode != null) {
81                nextNode.prev = first;
82            }
83
84            if (prevNode != null) {
85                if (prevNode.value > first.value && prevNode.value <= cost) {
86                    decreaseCount--;
87                } else if (
88                    prevNode.value <= first.value && prevNode.value > cost
89                ) {
90                    decreaseCount++;
91                }
92
93                pq.offer(new PQItem(prevNode, first, prevNode.value + cost));
94            }
95
96            if (nextNode != null) {
97                if (second.value > nextNode.value && cost <= nextNode.value) {
98                    decreaseCount--;
99                } else if (
100                    second.value <= nextNode.value && cost > nextNode.value
101                ) {
102                    decreaseCount++;
103                }
104
105                pq.offer(new PQItem(first, nextNode, cost + nextNode.value));
106            }
107
108            first.value = cost;
109            merged[second.left] = true;
110        }
111
112        return count;
113    }
114}
115