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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int lh=find(root.left);
        int rh=find(root.right);
        
        if(Math.abs(rh-lh)>1) return false;
         boolean left=isBalanced(root.left);
         boolean right=isBalanced(root.right);

         if(!left || !right){
            return false;
         }
         return true;
    }
    public int find(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(find(node.left),find(node.right));
    }
}