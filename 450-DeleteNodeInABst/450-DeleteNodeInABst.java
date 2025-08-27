// Last updated: 8/27/2025, 12:53:09 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // Node to be deleted found
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // Node has two children
                int max = max(root.left); // Get max from left subtree
                root.val = max; // Replace current node with max from left subtree
                root.left = deleteNode(root.left, max); // Delete the max node
            }
        }

        return root;
    }

    public int max(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        while (root.right != null) {
            root = root.right;
        }

        return root.val;
    }
}
