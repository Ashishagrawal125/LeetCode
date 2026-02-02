// Last updated: 2/2/2026, 11:59:53 PM
1class Container {
2
3    private int k;
4    private int st1Size;
5    private int st2Size;
6    // st1 saves the k smallest values, st2 saves the other values
7    private TreeMap<Integer, Integer> st1;
8    private TreeMap<Integer, Integer> st2;
9    // sm represents the sum of the first k smallest elements
10    private long sm;
11
12    public Container(int k) {
13        this.k = k;
14        this.st1 = new TreeMap<>();
15        this.st2 = new TreeMap<>();
16        this.sm = 0;
17        this.st1Size = 0;
18        this.st2Size = 0;
19    }
20
21    private void removeOne(TreeMap<Integer, Integer> map, int key) {
22        int count = map.get(key);
23        if (count == 1) {
24            map.remove(key);
25        } else {
26            map.put(key, count - 1);
27        }
28    }
29
30    private void addOne(TreeMap<Integer, Integer> map, int key) {
31        map.put(key, map.getOrDefault(key, 0) + 1);
32    }
33
34    private void adjust() {
35        while (st1Size < k && !st2.isEmpty()) {
36            int x = st2.firstKey();
37            addOne(st1, x);
38            st1Size++;
39            sm += x;
40            removeOne(st2, x);
41            st2Size--;
42        }
43        while (st1Size > k) {
44            int x = st1.lastKey();
45            addOne(st2, x);
46            st2Size++;
47            removeOne(st1, x);
48            st1Size--;
49            sm -= x;
50        }
51    }
52
53    // insert element x
54    public void add(int x) {
55        if (!st2.isEmpty() && x >= st2.firstKey()) {
56            addOne(st2, x);
57            st2Size++;
58        } else {
59            addOne(st1, x);
60            st1Size++;
61            sm += x;
62        }
63        adjust();
64    }
65
66    // delete element x
67    public void erase(int x) {
68        if (st1.containsKey(x)) {
69            removeOne(st1, x);
70            st1Size--;
71            sm -= x;
72        } else if (st2.containsKey(x)) {
73            removeOne(st2, x);
74            st2Size--;
75        }
76        adjust();
77    }
78
79    // sum of the first k smallest elements
80    public long sum() {
81        return sm;
82    }
83}
84
85class Solution {
86
87    public long minimumCost(int[] nums, int k, int dist) {
88        int n = nums.length;
89        Container cnt = new Container(k - 2);
90        for (int i = 1; i < k - 1; i++) {
91            cnt.add(nums[i]);
92        }
93
94        long ans = cnt.sum() + nums[k - 1];
95        for (int i = k; i < n; i++) {
96            int j = i - dist - 1;
97            if (j > 0) {
98                cnt.erase(nums[j]);
99            }
100            cnt.add(nums[i - 1]);
101            ans = Math.min(ans, cnt.sum() + nums[i]);
102        }
103
104        return ans + nums[0];
105    }
106}