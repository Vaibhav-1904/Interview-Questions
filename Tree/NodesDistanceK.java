package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;
import java.util.*;
// Given a Binary tree, a target node and distance k, you need to find all nodes at distance k from target Node
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

public class NodesDistanceK {
    // method for finding parent of each Node and store it in a Map
    // Using BFS traversal
    void markParents(TreeNode root, Map<TreeNode, TreeNode> parents){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode treeNode = q.remove();
            if(treeNode.left != null){
                q.add(treeNode.left);
                parents.put(treeNode.left, treeNode);
            }
            if(treeNode.right != null){
                q.add(treeNode.right);
                parents.put(treeNode.right, treeNode);
            }
        }
    }

    // Total T-> O(n+n)  ,   S->O(3n)
    // integer target is given, use BFS to find target Node
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        markParents(root, parents); // used for upwards traversal

        Map<TreeNode, Boolean> visited = new HashMap<>(); // not to visit same node again
        Queue<TreeNode> q = new LinkedList<>();

        visited.put(target, true);
        q.add(target);
        int d = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(d == k)
                break;
            d++;
            for(int i = 0; i < size; i++){
                TreeNode current = q.remove();
                // Downward Directions
                if(current.left != null && visited.get(current.left) == null){
                    q.add(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    q.add(current.right);
                    visited.put(current.right, true);
                }
                // Upward Direction
                if(parents.get(current) != null && visited.get(parents.get(current)) == null){
                    q.add(parents.get(current));
                    visited.put(parents.get(current), true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty())
            result.add(q.remove().val);

        return result;
    }
}
