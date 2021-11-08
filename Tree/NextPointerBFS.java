package ImportantQ.Tree;
import java.util.*;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class NextPointerBFS {
    public class Node{
        int val;
        Node left;
        Node right;
        Node next;
    }
    public Node connect(Node root) {
        if(root == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int j = 0;
            for(int i = 0; i < size; i++){
                j++;
                Node temp = q.remove();

                if(!q.isEmpty() && j != size){
                    temp.next = q.peek();
                }else{
                    temp.next = null;
                }

                if(temp.left != null){
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
        }

        return root;
    }
}
