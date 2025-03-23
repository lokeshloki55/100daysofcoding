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
   public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = 0;
        calcSum(root, sum, 0);
        return sum[0];
    }
    
    private void calcSum(TreeNode root, int[] sum, int ds) {
        if (root == null)   //this will be useful when we have only right or left subtree and another side we don't have elements
        return;   
        ds = ds * 10 + root.val;   //making the number
        if (root.left == null && root.right == null) {   //which means the dead end node
            sum[0] += ds;   //when we reach last node of that particular path we add up to sum
            ds=0;      
            return;
        }
        calcSum(root.left, sum, ds);
        calcSum(root.right, sum, ds);
    }
}
