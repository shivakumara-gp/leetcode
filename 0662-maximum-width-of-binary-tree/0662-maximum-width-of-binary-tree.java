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
 class Tuple{
    TreeNode node;
    int ind;
    public Tuple(TreeNode node,int ind){
        this.node=node;
        this.ind=ind;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Tuple> q=new LinkedList<>();
        int maxi=Integer.MIN_VALUE;
        q.offer(new Tuple(root,1));
        while(!q.isEmpty()){
            int length=q.size();
            int rightmost=0;
            int leftmost=0;
            for(int i=0;i<length;i++){
                Tuple cur=q.poll();
                TreeNode x=cur.node;
                int j=cur.ind;
                if(i==0){
                    leftmost=j;
                }
                if(i==length-1){
                    rightmost=j;
                }
                if(x.left!=null){
                    q.offer(new Tuple(x.left,2*j));
                }
                if(x.right!=null){
                    q.offer(new Tuple(x.right,2*j+1));
                }
            }
            maxi=Math.max(maxi,rightmost-leftmost+1);
        }
        return maxi;
    }
}