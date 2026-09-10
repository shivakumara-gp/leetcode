/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> cur1=new ArrayList<>();
        ArrayList<TreeNode> cur2=new ArrayList<>();
        pathFinder(root,p,cur1);
        pathFinder(root,q,cur2);
        int length1=cur1.size();
        int length2=cur2.size();
        int i=0;
        int j=0;
        TreeNode ans=null;
        while(i<length1 && j<length2){
            if(cur1.get(i)==cur2.get(j)){
                ans=cur1.get(i);
            }else{
                break;
            }
            i++;
            j++;
        }
        return ans;
    }

    public boolean pathFinder(TreeNode root,TreeNode x,ArrayList<TreeNode> cur){
        if(root==null){
            return false ;
        }
        cur.add(root);
        if(root.val==x.val){
            return true; 
        }
        if(pathFinder(root.left,x,cur) ||
         pathFinder(root.right,x,cur)){
            return true;
         }
        
        cur.remove(cur.size()-1);
        return false;
    }
}