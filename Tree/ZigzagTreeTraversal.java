package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;
import java.util.*;
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/

public class ZigzagTreeTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return result;
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < levelSize; i++){
                TreeNode treeNode = q.remove();

                if(treeNode.left != null)
                    q.add(treeNode.left);
                if(treeNode.right != null)
                    q.add(treeNode.right);

                if(flag)
                    level.add(treeNode.val);
                else
                    level.add(0, treeNode.val); // add in reverse order
            }
            flag = !flag;
            result.add(level);
        }
        return result;
    }
}
