/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {

    public boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }


    public void leftBoundary(Node root, ArrayList<Integer> res) {

        while (root != null) {

            if (!isLeaf(root)) {
                res.add(root.data);
            }

            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }


    public void leaves(Node root, ArrayList<Integer> res) {

        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        leaves(root.left, res);
        leaves(root.right, res);
    }


    public void rightBoundary(Node root, ArrayList<Integer> res) {

        ArrayList<Integer> cur = new ArrayList<>();

        while (root != null) {

            if (!isLeaf(root)) {
                cur.add(root.data);
            }

            if (root.right != null) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        for (int i = cur.size() - 1; i >= 0; i--) {
            res.add(cur.get(i));
        }
    }


    public ArrayList<Integer> boundaryTraversal(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // Root
        if (!isLeaf(root)) {
            ans.add(root.data);
        }

        // Left Boundary
        leftBoundary(root.left, ans);

        // Leaf Nodes
        leaves(root, ans);

        // Right Boundary
        rightBoundary(root.right, ans);

        return ans;
    }
}