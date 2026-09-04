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
    int maxi=Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
       maxSum(root);
        return maxi;
    }
    public int maxSum(TreeNode node){
        if(node==null){
            return 0;
        }
        
        int lh=Math.max(0,maxSum(node.left));
        
        
        int rh=Math.max(0,maxSum(node.right));
        
        maxi=Math.max(maxi,lh+rh+node.val);
        
        
        return node.val+Math.max(lh,rh);
    }
}