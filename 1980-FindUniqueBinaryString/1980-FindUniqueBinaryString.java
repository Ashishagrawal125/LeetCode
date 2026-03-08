// Last updated: 3/8/2026, 10:29:55 AM
1class Solution {
2    int n;
3    Set<String> numsSet = new HashSet();
4    
5    private String generate(String curr) {
6        if (curr.length() == n) {
7            if (!numsSet.contains(curr)) {
8                return curr;
9            }
10            
11            return "";
12        }
13        
14        String addZero = generate(curr + "0");
15        if (addZero.length() > 0) {
16            return addZero;
17        }
18        
19        return generate(curr + "1");
20    }
21    
22    public String findDifferentBinaryString(String[] nums) {
23        n = nums.length;
24        for (String s : nums) {
25            numsSet.add(s);
26        }
27        
28        return generate("");
29    }
30}