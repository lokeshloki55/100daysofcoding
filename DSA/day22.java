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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)  //both should be null
            return true;
        if (p == null || q == null)  //if only one is null then false
            return false;
        
        
        if (p.val == q.val)    //if both are not null values of both should be same
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);  
            //left traversal and right traversal both should return true.
        
        return false;    //if not satisfies any one of the conditions above then false
    }
}
