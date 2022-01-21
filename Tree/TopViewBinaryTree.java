package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;
import java.util.*;
// https://www.geeksforgeeks.org/print-nodes-in-the-top-view-of-binary-tree-set-3/

public class TopViewBinaryTree {
    static class Pair{
        TreeNode treeNode;
        int line;
        public Pair(TreeNode treeNode, int line){
            this.treeNode = treeNode;
            this.line = line;
        }
    }
    // T -> O(n) S-> O(2n)
    static ArrayList<Integer> topView(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Map<Integer, Integer> map = new TreeMap<>();// line, node.data
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair current = q.remove();
            TreeNode temp = current.treeNode;
            int line = current.line;
            if(!map.containsKey(line))
                map.put(line, temp.val);

            if(temp.left != null)
                q.add(new Pair(temp.left, line - 1));

            if(temp.right != null)
                q.add(new Pair(temp.right, line + 1));
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}
