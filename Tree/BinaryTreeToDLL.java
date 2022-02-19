package ImportantQ.Tree;
// https://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
public class BinaryTreeToDLL {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node bToDLL(Node root) {
        if(root == null)
            return null;

        Node dummy = new Node(-1);
        Node current = root;
        Node prev = dummy;

        while(current != null) {
            if(current.left == null) {
                prev.right = current;
                current.left = prev;
                prev = current;
                current = current.right;
            }else{
                Node pre = findRightMost(current.left, current);

                if(pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }else{
                    prev.right = current;
                    current.left = prev;
                    prev = current;
                    current = current.right;
                }
            }
        }

        Node head = dummy.right;
        head.left = null;

        return head;
    }

    static Node findRightMost(Node root, Node current) {
        while(root.right != null &&  root.right != current)
            root = root.right;

        return root;
    }
}
