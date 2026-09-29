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
    int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length-1;
        return binaryTree(preorder,inorder,0,n);
    }
    public int find(int rootvalue,int[] inorder){
        for(int i=0;i<inorder.length;i++){
            if(rootvalue==inorder[i]){
                return i;
            }
        }
        return -1;
    }

    public TreeNode binaryTree(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootvalue = preorder[preindex++];
        TreeNode root = new TreeNode(rootvalue);

        int index=find(rootvalue,inorder);
        root.left=binaryTree(preorder,inorder,left,index-1);
        root.right=binaryTree(preorder,inorder,index+1,right);
        return root;
    }
}