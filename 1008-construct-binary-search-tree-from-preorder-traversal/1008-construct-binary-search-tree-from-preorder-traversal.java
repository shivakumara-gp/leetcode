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
    
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null;
        for(int x:preorder){
            root=insertNodes(root,x);
        }
        return root;
    }
    public TreeNode insertNodes(TreeNode root,int key){
        TreeNode newNode=new TreeNode(key);
        if(root==null) return newNode;

        TreeNode cur=root;
        TreeNode parent=null;

        while(cur!=null){
            parent=cur;
            if(cur.val>key){
                cur=cur.left;
            }
            else{
                cur=cur.right;
            }
        }
        if(key<parent.val){
            parent.left=newNode;
        }
        if(key>parent.val){
            parent.right=newNode;
        }
        return root;
    }
}