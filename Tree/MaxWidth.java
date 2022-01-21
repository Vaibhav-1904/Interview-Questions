package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;
import java.util.*;
// width is number of nodes between 2 nodes at same level
// return maximum number of nodes in a Level
// https://leetcode.com/problems/maximum-width-of-binary-tree/

public class MaxWidth {
    class Pair{
        TreeNode treeNode;
        int index;
        public Pair(TreeNode treeNode, int index){
            this.treeNode = treeNode;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int result = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int first = 0, last = 0;
            int minIndex = q.peek().index; // minimum index possible on that level
            for(int i = 0; i < size; i++){
                int current = q.peek().index - minIndex;
                TreeNode treeNode = q.remove().treeNode;
                if(i == 0)
                    first = current;
                if(i == size-1)
                    last = current;
                if(treeNode.left != null)
                    q.add(new Pair(treeNode.left, current*2 + 1));
                if(treeNode.right != null)
                    q.add(new Pair(treeNode.right, current*2 + 2));
            }
            result = Math.max(result, last - first + 1);
        }
        return result;
    }
}
