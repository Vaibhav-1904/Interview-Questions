package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
import java.util.*;
// Given a Binary tree, a target node and distance k, you need to find all nodes at distance k from target Node
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

public class NodesDistanceK {
    // method for finding parent of each Node and store it in a Map
    // Using BFS traversal
    void markParents(Node root, Map<Node, Node> parents){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node node = q.remove();
            if(node.left != null){
                q.add(node.left);
                parents.put(node.left, node);
            }
            if(node.right != null){
                q.add(node.right);
                parents.put(node.right, node);
            }
        }
    }

    // Total T-> O(n+n)  ,   S->O(3n)
    // integer target is given, use BFS to find target Node
    public List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node, Node> parents = new HashMap<>();
        markParents(root, parents); // used for upwards traversal

        Map<Node, Boolean> visited = new HashMap<>(); // not to visit same node again
        Queue<Node> q = new LinkedList<>();

        visited.put(target, true);
        q.add(target);
        int d = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(d == k)
                break;
            d++;
            for(int i = 0; i < size; i++){
                Node current = q.remove();
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
            result.add(q.remove().data);

        return result;
    }
}
