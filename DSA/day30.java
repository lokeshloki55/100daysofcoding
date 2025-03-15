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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer>inordermap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inordermap.put(inorder[i],i);
        }

        TreeNode root=building(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inordermap);

        return root;
    }

    public TreeNode building(int postorder[],int postart,int poend,int inorder[],int iostart,int ioend,Map<Integer,Integer>inordermap){

        if(postart>poend||iostart>ioend){
            return null;
        }

        TreeNode root=new TreeNode(postorder[poend]);   //has to take last index of postaorder as root value.

        int rootind=inordermap.get(postorder[poend]);
        int numslen=rootind-iostart;

        root.left=building(postorder,postart,postart+numslen-1,inorder,iostart,rootind-1,inordermap);//changes in postorder indexes
        root.right=building(postorder,postart+numslen,poend-1,inorder,rootind+1,ioend,inordermap);

        return root;
    }
}
