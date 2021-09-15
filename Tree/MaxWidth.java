package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
import java.util.*;
// width is number of nodes between 2 nodes at same level
// return maximum number of nodes in a Level
// https://leetcode.com/problems/maximum-width-of-binary-tree/

public class MaxWidth {
    class Pair{
        Node node;
        int index;
        public Pair(Node node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(Node root) {
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
                Node node = q.remove().node;
                if(i == 0)
                    first = current;
                if(i == size-1)
                    last = current;
                if(node.left != null)
                    q.add(new Pair(node.left, current*2 + 1));
                if(node.right != null)
                    q.add(new Pair(node.right, current*2 + 2));
            }
            result = Math.max(result, last - first + 1);
        }
        return result;
    }
}
