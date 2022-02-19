package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;
import java.util.*;
// You have been given a binary tree of 'N' unique nodes and a Start node from where the tree will start to burn.
// Given that the Start node will always exist in the tree, your task is to print the time (in minutes)
// that it will take to burn the whole tree.
public class TimeToBurnBinaryTree {

    public static void markParents(TreeNode root, Map<TreeNode, TreeNode> parents){
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

    public static TreeNode findTarget(TreeNode root, int target){

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(true){
            if(q.peek().val == target)
                break;
            TreeNode treeNode = q.remove();

            if(treeNode.left != null)
                q.add(treeNode.left);

            if(treeNode.right != null)
                q.add(treeNode.right);
        }
        return q.peek();
    }
    // T-> O(2n),  S->O(3n)
    public static int timeToBurnTree(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        markParents(root, parents);

        Map<TreeNode, Boolean> isVisited = new HashMap<>(); // not to visit same node again
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode target = findTarget(root, start);
        isVisited.put(target, true);
        q.add(target);
        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int f = 0; // to keep a check if any Node in tree is left to be burnt
            for(int i = 0; i < size; i++){
                TreeNode current = q.remove();
                // Downward Directions
                if(current.left != null && isVisited.get(current.left) == null){
                    f = 1;
                    q.add(current.left);
                    isVisited.put(current.left, true);
                }
                if(current.right != null && isVisited.get(current.right) == null){
                    f = 1;
                    q.add(current.right);
                    isVisited.put(current.right, true);
                }
                // Upward Direction
                if(parents.get(current) != null && isVisited.get(parents.get(current)) == null){
                    f = 1;
                    q.add(parents.get(current));
                    isVisited.put(parents.get(current), true);
                }
            }
            if(f == 1)
                time++;
        }
        return time;
    }
}
