// Last updated: 2/11/2026, 12:45:37 PM
1class Solution {
2    static class Trie{
3        class Node {
4            Node zero;
5            Node one;
6        }
7        private Node root = new Node();
8        public void add(int val){
9            Node curr = root;
10            for(int i=31;i>=0;i--){
11                int bit = val&(1<<i);
12                if(bit ==0){
13                    if(curr.zero!=null){
14                        curr = curr.zero;
15                    }else{
16                        Node nn = new Node();
17                        curr.zero = nn;
18                        curr = nn;
19                    }
20                }else{
21                    if(curr.one!=null){
22                        curr = curr.one;
23                    }else{
24                        Node nn = new Node();
25                        curr.one = nn;
26                        curr = nn;
27                    }
28
29                }
30            }
31        }
32        public int getMaxXOR(int x){
33            int ans = 0;
34            Node curr = root;
35            for(int i=31;i>=0;i--){
36                int bit = x&(1<<i);
37                if(bit==0){
38                    if(curr.one!=null){
39                        ans = ans | (1<<i);
40                        curr = curr.one;
41                    }else{
42                        curr = curr.zero;
43                    }
44                }else{
45                    if(curr.zero!=null){
46                        ans = ans | (1<<i);
47                        curr = curr.zero;
48                    }else{
49                        curr = curr.one;
50                    }
51                }
52            }
53            return ans;
54        }
55    }
56
57    public int findMaximumXOR(int[] nums) {
58        Trie trie = new Trie();
59        for(int x : nums){
60            trie.add(x);
61        }
62        int ans = 0;
63        for(int x: nums){
64            ans = Math.max(trie.getMaxXOR(x),ans);
65        }
66        return ans;
67    }
68}