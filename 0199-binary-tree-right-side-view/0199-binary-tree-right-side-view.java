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
//  class Tuple {
    
//     TreeNode node;
//     int hd;

//     public Tuple(TreeNode _node, int _hd) {
//         node = _node;
//         hd = _hd;
//     }
// }
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
         ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

           int length=q.size();
            for(int i=0;i<length;i++){
                
            TreeNode node=q.poll();
            if(i==length-1){
                ans.add(node.val);
            }
            if (node.left != null) {
                q.offer(node.left);
            }

            if (node.right != null) {
                q.offer(node.right);
            }
        }
           
      }


        return ans;
    }
}
// ArrayList<Integer> ans = new ArrayList<>();

//         if (root == null) {
//             return ans;
//         }

//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         Queue<Tuple> q = new LinkedList<>();

//         q.offer(new Tuple(root, 0));

//         while (!q.isEmpty()) {

//             Tuple cur = q.poll();

//             TreeNode node = cur.node;
//             int hd = cur.hd;

            
//             map.put(hd, node.val);

//             if (node.left != null) {
//                 q.offer(new Tuple(node.left, hd+1));
//             }

//             if (node.right != null) {
//                 q.offer(new Tuple(node.right, hd + 1));
//             }
//         }

//         for (int value : map.values()) {
//             ans.add(value);
//         }

//         return ans;


