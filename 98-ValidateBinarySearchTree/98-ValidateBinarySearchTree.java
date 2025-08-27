// Last updated: 8/27/2025, 12:53:58 PM
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
    public boolean isValidBST(TreeNode root) {
        return isBST(root).isbst;
    }

    public BstPair isBST(TreeNode root) {
        if (root == null) {
            return new BstPair(); // default isbst = true, min = MAX, max = MIN
        }

        BstPair left = isBST(root.left);
        BstPair right = isBST(root.right);

        BstPair curr = new BstPair();
        curr.min = Math.min(root.val, Math.min(left.min, right.min));
        curr.max = Math.max(root.val, Math.max(left.max, right.max));
        curr.isbst = left.isbst && right.isbst && (left.max < root.val) && (root.val < right.min);

        return curr;
    }

    class BstPair {
        boolean isbst = true;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
    }
}
