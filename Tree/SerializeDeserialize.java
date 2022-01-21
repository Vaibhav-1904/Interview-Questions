package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;
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
    public String serialize(TreeNode root) {
        if(root == null)
            return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode treeNode = q.remove();
            if(treeNode == null) {
                result.append("n ");
                continue;
            }
            result.append(treeNode.val + " ");
            q.add(treeNode.left);
            q.add(treeNode.right);
        }
        return result.toString();
    }

    // Decodes your encoded data String to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0)
            return null;

        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        for(int i = 1; i < values.length; i++) {
            TreeNode current = q.remove();
            // Assigning Left Child
            if(!values[i].equals("n")){ // if string[i] is a number or Nan Value
                TreeNode temp = new TreeNode(Integer.parseInt(values[i]));
                q.add(temp);
                current.left = temp;
            }
            // Assigning Right Child
            if(!values[++i].equals("n")){
                TreeNode temp = new TreeNode(Integer.parseInt(values[i]));
                q.add(temp);
                current.right = temp;
            }
        }
        return root;
    }
}
