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
// class Solution {
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         if(root==null) return new TreeNode(val) ;
//         if(root.val<val && root.right==null){
//             TreeNode cur=new TreeNode(val);
//             root.right=cur;
//             return root;
//         }else if(root.val>val && root.left==null){
//             TreeNode cur=new TreeNode(val);
//             root.left=cur;
//             return root;
//         }
//         if(val>root.val){
//             insertIntoBST(root.right,val);
//         }else{
//             insertIntoBST(root.left,val);
//         } 
//         return root;
//     }
// }
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}