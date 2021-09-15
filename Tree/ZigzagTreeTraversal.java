package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
import java.util.*;
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/

public class ZigzagTreeTraversal {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root == null)
            return result;
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < levelSize; i++){
                Node node = q.remove();

                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);

                if(flag)
                    level.add(node.data);
                else
                    level.add(0, node.data); // add in reverse order
            }
            flag = !flag;
            result.add(level);
        }
        return result;
    }
}
