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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean leftToright=true;
        if(root==null){
            return ans;
        }
        Queue<TreeNode> nodesQueue=new LinkedList<>();
        nodesQueue.offer(root);
        while(!nodesQueue.isEmpty()){
            int length=nodesQueue.size();
            int row[]=new int[length];
            for(int i=0;i<length;i++){
                TreeNode cur=nodesQueue.poll();
                int index=(leftToright)?i:(length-1-i);
                row[index]=cur.val;
                if(cur.left!=null){
                    nodesQueue.offer(cur.left);
                }
                if(cur.right!=null){
                    nodesQueue.offer(cur.right);
                }
            }
            leftToright=!leftToright;
            ArrayList<Integer> level=new ArrayList<>();
            for(int num:row){
                level.add(num);
            }
            ans.add(new ArrayList<>(level));
        }
        return ans;

    }
}