package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
import java.util.*;
// You have been given a binary tree of 'N' unique nodes and a Start node from where the tree will start to burn.
// Given that the Start node will always exist in the tree, your task is to print the time (in minutes)
// that it will take to burn the whole tree.
public class TimeToBurnBinaryTree {
    // T-> O(2n),  S->O(3n)
    public static int timeToBurnTree(Node root, int start)
    {
        Map<Node, Node> parents = new HashMap<>();
        markParents(root, parents);

        Map<Node, Boolean> visited = new HashMap<>(); // not to visit same node again
        Queue<Node> q = new LinkedList<>();

        Node target = findTarget(root, start);
        visited.put(target, true);
        q.add(target);
        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int f = 0;
            for(int i = 0; i < size; i++){
                Node current = q.remove();
                // Downward Directions
                if(current.left != null && visited.get(current.left) == null){
                    f = 1;
                    q.add(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    f = 1;
                    q.add(current.right);
                    visited.put(current.right, true);
                }
                // Upward Direction
                if(parents.get(current) != null && visited.get(parents.get(current)) == null){
                    f = 1;
                    q.add(parents.get(current));
                    visited.put(parents.get(current), true);
                }
            }
            if(f == 1)
                time++;
        }
        return time;
    }

    public static void markParents(Node root, Map<Node, Node> parents){
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

    public static Node findTarget(Node root, int target){

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(true){
            if(q.peek().data == target)
                break;
            Node node = q.remove();

            if(node.left != null)
                q.add(node.left);

            if(node.right != null)
                q.add(node.right);

        }
        return q.peek();
    }
}
