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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer>inordermap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inordermap.put(inorder[i],i);
        }
        TreeNode root=building(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inordermap);
        return root;
    }

    public TreeNode building(int preorder[],int postart,int poend,int inorder[],int iostart,int ioend,Map<Integer,Integer>inordermap){

        if(postart>poend||iostart>ioend){
            return null;
        }
        TreeNode root=new TreeNode(preorder[postart]);
        int rootind=inordermap.get(preorder[postart]);
        int numslen=rootind-iostart;
        root.left=building(preorder,postart+1,postart+numslen,inorder,iostart,rootind-1,inordermap);//see note
        root.right=building(preorder,postart+numslen+1,poend,inorder,rootind+1,ioend,inordermap);
        return root;
    }
}
