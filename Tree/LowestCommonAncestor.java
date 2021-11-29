package ImportantQ.Tree;

import ImportantQ.Tree.TreeNode.Node;
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

public class LowestCommonAncestor {
//    // Naive Approach T-> O(n), S-> O(n)
//    public Node lowestCommonAncestor(Node root, Node p, Node q) {
//        ArrayList<Node> PPath = new ArrayList<>();
//        path(root, PPath, p.data);
//
//        ArrayList<Node> QPath = new ArrayList<>();
//        path(root, QPath, q.data);
//
//        Node ans = null;
//        for(int i = 0; i < Math.min(PPath.size(), QPath.size()); i++){
//            if(PPath.get(i).data == QPath.get(i).data)
//                ans = PPath.get(i);
//            else{
//                ans = PPath.get(--i);
//                break;
//            }
//        }
//        return ans;
//    }
//    // Used to find path of a Particular Node
//    public boolean path(Node root, ArrayList<Node> result, int b){
//        if(root == null)
//            return false;
//
//        result.add(root);
//        if(root.data == b)
//            return true;
//
//        boolean left = false, right = false;
//
//        if(root.left != null)
//            left = path(root.left, result, b);
//        if(root.right != null)
//            right = path(root.right, result, b);
//
//        if(left || right)
//            return true;
//
//        result.remove(result.size() - 1);
//        return false;
//    }

    // Optimal Approach S->O(n)
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null || root == p || root == q)
            return root;

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if(left == null)
            return right;
        else if(right == null)
            return left;
        else // it is the situation where we got our LCA answer
            return root;
    }
}
