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
    int cnt=0;
    int val=0;
    public int kthSmallest(TreeNode root, int k) {
        val=0;
        smallest(root,k);
        return val;
    }
    public void smallest(TreeNode root,int k){
        if(root==null) return;
        smallest(root.left,k);
        cnt++;
        if(cnt==k){
            val=root.val;
            return;
        }
        smallest(root.right,k);
    }
}