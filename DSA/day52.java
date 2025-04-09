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
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
     public boolean isValidBST(TreeNode root,long min,long max) {
        if(root==null)
        return true;//as we reached last node without any struggles.
        if(root.val>=max||root.val<=min)//if number is not within range return false
        return false;

        return isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max);//both sides should satisfy the condition.
        
    }
}
