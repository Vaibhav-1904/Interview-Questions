package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;
import java.util.*;
// https://www.youtube.com/watch?v=80Zug6D1_r4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=38

// Amortized T -> O(n+n) , S->O(1)
public class MorrisTraversal {
    // Inorder
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                result.add(current.val);
                current = current.right;
            }else{
                TreeNode pre = current.left;
                while(pre.right != null && pre.right != current)
                    pre = pre.right;
                if(pre.right == null){
                    pre.right = current; // Creating a Thread link to the ROOT
                    current = current.left;
                }
                else{
                    pre.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        return result;
    }

    //Preorder
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                result.add(current.val);
                current = current.right;
            }else{
                TreeNode pre = current.left;
                while(pre.right != null && pre.right != current)
                    pre = pre.right;
                if(pre.right == null){
                    pre.right = current; // Creating a Thread link to the ROOT
                    result.add(current.val);
                    current = current.left;
                }
                else{ // if pre.right == current
                    pre.right = null;
                    current = current.right;
                }
            }
        }
        return result;
    }
}
