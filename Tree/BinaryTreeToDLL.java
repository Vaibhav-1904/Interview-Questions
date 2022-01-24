package ImportantQ.Tree;

public class BinaryTreeToDLL {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
        }
    }

    Node bToDLL(Node root)
    {
        if(root == null)
            return null;

        Node dummy = new Node(-1);
        Node current = root, prev = dummy;

        while(current != null) {
            if(current.left == null){
                prev.right = current;
                current.left = prev;
                prev = current;
                current = current.right;
            }else{
                Node pre = current.left;
                while(pre.right != null &&  pre.right != current)
                    pre = pre.right;

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
        dummy.right = null;;

        return head;
    }
}
