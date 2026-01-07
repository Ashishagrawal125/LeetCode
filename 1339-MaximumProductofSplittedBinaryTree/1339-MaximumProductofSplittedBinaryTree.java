// Last updated: 1/7/2026, 12:57:24 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    static final int MOD = 1_000_000_007;
18    long totalSum = 0;
19    long maxProduct = 0;
20
21    // First DFS: compute total tree sum
22    long getTotalSum(TreeNode root) {
23        if (root == null) return 0;
24        return root.val 
25             + getTotalSum(root.left) 
26             + getTotalSum(root.right);
27    }
28
29    // Second DFS (postorder): compute subtree sums
30    long dfs(TreeNode root) {
31        if (root == null) return 0;
32
33        // Get sums of left and right subtrees
34        long left = dfs(root.left);
35        long right = dfs(root.right);
36
37        // Current subtree sum
38        long subSum = root.val + left + right;
39
40        // Try splitting above this node
41        long product = subSum * (totalSum - subSum);
42        maxProduct = Math.max(maxProduct, product);
43
44        return subSum;
45    }
46
47    public int maxProduct(TreeNode root) {
48        totalSum = getTotalSum(root); // O(n)
49        dfs(root);                    // O(n)
50        return (int)(maxProduct % MOD);
51    }
52}