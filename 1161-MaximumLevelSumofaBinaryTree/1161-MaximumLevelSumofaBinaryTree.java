// Last updated: 1/6/2026, 11:07:27 AM
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
17    public int maxLevelSum(TreeNode root) {
18        int maxSum = Integer.MIN_VALUE;
19        int ans = 0, level = 0;
20
21        Queue<TreeNode> q = new LinkedList<>();
22        q.offer(root);
23
24        while (!q.isEmpty()) {
25            level++;
26            int sumAtCurrentLevel = 0;
27            // Iterate over all the nodes in the current level.
28            for (int sz = q.size(); sz > 0; --sz) {
29                TreeNode node = q.poll();
30                sumAtCurrentLevel += node.val;
31
32                if (node.left != null) {
33                    q.offer(node.left);
34                }
35                if (node.right != null) {
36                    q.offer(node.right);
37                }
38            }
39
40            if (maxSum < sumAtCurrentLevel) {
41                maxSum = sumAtCurrentLevel;
42                ans = level;
43            }
44        }
45
46        return ans;
47    }
48}