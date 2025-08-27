// Last updated: 8/27/2025, 12:53:45 PM
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
     int sum =0;
    int k =0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
        {
            return k;
        }
        sum = sum*10+root.val;
        if(root.right==null&&root.left==null)
        {
            k=k+sum;
        }
        sumNumbers(root.left);
        sumNumbers(root.right);
        sum=sum/10;
        return k;
    }
}