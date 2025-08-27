// Last updated: 8/27/2025, 12:53:06 PM
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
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).dt;
    
    }
    public DiaPair diameter(TreeNode root){
        if(root == null){
            return new DiaPair();
        }
        DiaPair ldp = diameter(root.left);// dt ht
        DiaPair rdp = diameter(root.right);// dt ht
        int sd = ldp.ht + rdp.ht + 2;
        DiaPair sdp = new DiaPair();
        sdp.dt = Math.max(sd, Math.max(rdp.dt, ldp.dt));
        sdp.ht = Math.max(ldp.ht, rdp.ht)+1;
        return sdp; 
    }
    class DiaPair{
        int dt = 0;
        int ht = -1;
    }
}