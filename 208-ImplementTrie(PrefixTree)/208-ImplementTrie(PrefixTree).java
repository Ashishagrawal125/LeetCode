// Last updated: 2/4/2026, 12:27:52 PM
1class Trie {
2    class Node{
3        char ch;
4        boolean isterminal;
5        HashMap<Character,Node> child;
6        public Node(char ch){
7            this.ch = ch;
8            child = new HashMap<>();
9        }
10    }
11    private Node root;
12
13    public Trie() {
14        root = new Node('*');
15        
16    }
17    
18    public void insert(String word) {
19        Node curr = root;
20        for(int i =0;i<word.length();i++){
21            char ch = word.charAt(i);
22            if(curr.child.containsKey(ch)){
23                curr = curr.child.get(ch);
24
25            }
26            else{
27                Node nn = new Node(ch);
28                curr.child.put(ch,nn);
29                curr =nn;
30            }
31        }
32        curr.isterminal = true;
33
34        
35    }
36    
37    public boolean search(String word) {
38        Node curr = root;
39        for(int i =0;i<word.length();i++){
40            char ch = word.charAt(i);
41            if(curr.child.containsKey(ch)){
42                curr = curr.child.get(ch);
43
44            }
45            else{
46                return false;
47            }
48        }
49        return curr.isterminal;
50        
51    }
52    
53    public boolean startsWith(String prefix) {
54        Node curr = root;
55        for(int i =0;i<prefix.length();i++){
56            char ch = prefix.charAt(i);
57            if(curr.child.containsKey(ch)){
58                curr = curr.child.get(ch);
59
60            }
61            else{
62                return false;
63            }
64        }
65        return true;
66        
67        
68    }
69}
70
71/**
72 * Your Trie object will be instantiated and called as such:
73 * Trie obj = new Trie();
74 * obj.insert(word);
75 * boolean param_2 = obj.search(word);
76 * boolean param_3 = obj.startsWith(prefix);
77 */ 
78
79/**
80 * Your Trie object will be instantiated and called as such:
81 * Trie obj = new Trie();
82 * obj.insert(word);
83 * boolean param_2 = obj.search(word);
84 * boolean param_3 = obj.startsWith(prefix);
85 */