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
    int postindex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postindex=postorder.length-1;
        return binaryTree(postorder,inorder,0,inorder.length-1);
    }
    public int find(int rootvalue,int[] inorder){
        for(int i=0;i<inorder.length;i++){
            if(rootvalue==inorder[i]){
                return i;
            }
        }
        return -1;
    }

    public TreeNode binaryTree(int[] postorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootvalue = postorder[postindex--];
        
        TreeNode root = new TreeNode(rootvalue);

        int index=find(rootvalue,inorder);
        
        root.right=binaryTree(postorder,inorder,index+1,right);
        root.left=binaryTree(postorder,inorder,left,index-1);
        return root;
    }
}