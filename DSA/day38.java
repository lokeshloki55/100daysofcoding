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
    public int maxPathSum(TreeNode root) {
        int maxi[]=new int[1];
        maxi[0]=Integer.MIN_VALUE;
        func(root,maxi,0);
        System.out.print(arr);
        return maxi[0]; 
    }
    public static ArrayList<Integer>arr=new ArrayList<>();

    public int func(TreeNode root,int[] maxi,int temp){
        if(root==null){
        arr.add(temp);
        return 0;
        }
        int left=Math.max(0,func(root.left,maxi,temp+root.val));
        int right=Math.max(0,func(root.right,maxi,temp+root.val));  //math.max is used to discard negative path
        maxi[0]=Math.max(maxi[0],root.val+left+right);  //for umbrella shaped path
        return root.val+Math.max(left,right);//to choose a path from or left or right
    }
}
