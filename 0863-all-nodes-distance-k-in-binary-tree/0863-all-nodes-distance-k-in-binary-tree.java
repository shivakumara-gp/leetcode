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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track=new HashMap<>();
        marksParent(root,parent_track);
        Map<TreeNode, Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        int cur_level=0;
        q.offer(target);
        visited.put(target,true);
        while(!q.isEmpty()){
            int size=q.size();
            if(cur_level==k) break;
            cur_level++;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    q.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    q.offer(node.right);
                    visited.put(node.right,true);
                }
                if(parent_track.get(node)!=null && visited.get(parent_track.get(node))==null){
                    q.offer(parent_track.get(node));
                    visited.put(parent_track.get(node),true);
                }
                
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            
            ans.add(cur.val);
        }
        return ans;
    }
    public void marksParent(TreeNode root,Map<TreeNode,TreeNode> parent_track){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur.left!=null){
                q.offer(cur.left);
                parent_track.put(cur.left,cur);
            }
            if(cur.right!=null){
                q.offer(cur.right);
                parent_track.put(cur.right,cur);
            }
        }
    }


    
    
}