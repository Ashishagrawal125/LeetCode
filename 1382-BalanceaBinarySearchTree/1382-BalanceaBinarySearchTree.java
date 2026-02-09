// Last updated: 2/9/2026, 1:19:09 PM
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
17
18    public TreeNode balanceBST(TreeNode root) {
19        // Create a list to store the inorder traversal of the BST
20        List<Integer> inorder = new ArrayList<>();
21        inorderTraversal(root, inorder);
22
23        // Construct and return the balanced BST
24        return createBalancedBST(inorder, 0, inorder.size() - 1);
25    }
26
27    private void inorderTraversal(TreeNode root, List<Integer> inorder) {
28        // Perform an inorder traversal to store the elements in sorted order
29        if (root == null) return;
30        inorderTraversal(root.left, inorder);
31        inorder.add(root.val);
32        inorderTraversal(root.right, inorder);
33    }
34
35    private TreeNode createBalancedBST(
36        List<Integer> inorder,
37        int start,
38        int end
39    ) {
40        // Base case: if the start index is greater than the end index, return null
41        if (start > end) return null;
42
43        // Find the middle element of the current range
44        int mid = start + (end - start) / 2;
45
46        // Recursively construct the left and right subtrees
47        TreeNode leftSubtree = createBalancedBST(inorder, start, mid - 1);
48        TreeNode rightSubtree = createBalancedBST(inorder, mid + 1, end);
49
50        // Create a new node with the middle element and attach the subtrees
51        TreeNode node = new TreeNode(
52            inorder.get(mid),
53            leftSubtree,
54            rightSubtree
55        );
56        return node;
57    }
58}