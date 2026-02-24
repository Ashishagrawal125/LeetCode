// Last updated: 2/24/2026, 2:13:38 PM
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
17    public int sumRootToLeaf(TreeNode root) {
18        return DFS(root, 0);
19    }
20
21    public int DFS(TreeNode rt, int x) {
22        if (rt==null) return 0;
23        x = x*2 + rt.val;
24        if(rt.left==rt.right) return x;
25        return DFS(rt.left, x) + DFS(rt.right, x);
26    }
27}