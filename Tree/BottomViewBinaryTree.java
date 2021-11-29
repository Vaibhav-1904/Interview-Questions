package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
import java.util.*;
// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

public class BottomViewBinaryTree {
    static class Pair{
        Node node;
        int line;
        public Pair(Node node, int line){
            this.node = node;
            this.line = line;
        }
    }
    // T -> O(n) S-> O(2n)
    static ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Map<Integer, Integer> map = new TreeMap<>();// line, node.data
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair current = q.remove();
            Node node = current.node;
            int line = current.line;
            if(map.containsKey(line))
                map.replace(line, node.data);
            else
                map.put(line, node.data);

            if(node.left != null)
                q.add(new Pair(node.left, line - 1));

            if(node.right != null)
                q.add(new Pair(node.right, line + 1));
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}
