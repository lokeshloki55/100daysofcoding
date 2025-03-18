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
    TreeNode head=null;//consider it as previous.
    
    public void flatten(TreeNode root) {
        if (root != null) revPreOrder(root);
    }
    private void revPreOrder(TreeNode node) {
        if (node.right != null) 
        revPreOrder(node.right);  //go to the right most bottom first.

        if (node.left != null) 
        revPreOrder(node.left);
        
        node.left = null; 
        node.right = head;
        head = node;
    }
}
