package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
import java.util.*;
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// Serialization is the process of converting a data structure or object into a sequence of bits
// so that it can be stored in a file or memory buffer, or transmitted across a network connection
// link to be reconstructed later in the same or another computer environment.
//
//Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
// your serialization/deserialization algorithm should work. You just need to ensure that a binary
// tree can be serialized to a string and this string can be deserialized to the original tree structure.

public class SerializeDeserialize {
    // T->O(n) ,  S->(n)
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null)
            return "";

        Queue<Node> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            if(node == null)
            {
                result.append("n ");
                continue;
            }
            result.append(node.data + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0)
            return null;

        String[] values = data.split(" ");
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);

        for(int i = 1; i < values.length; i++){
            Node current = q.remove();
            if(!values[i].equals("n")){ // if string[i] is a number or Nan Value
                Node temp = new Node(Integer.parseInt(values[i]));
                q.add(temp);
                current.left = temp;
            }
            if(!values[++i].equals("n")){
                Node temp = new Node(Integer.parseInt(values[i]));
                q.add(temp);
                current.right = temp;
            }
        }
        return root;
    }
}
