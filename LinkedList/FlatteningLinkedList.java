package ImportantQ.LinkedList;
// https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1#
public class FlatteningLinkedList {
    static class Node
    {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }

    public static Node mergeList(Node l1, Node l2){
        Node temp = new Node(0);
        Node result = temp;

        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                temp.bottom = l1;
                temp = temp.bottom;
                l1 = l1.bottom;
            }else{
                temp.bottom = l2;
                temp = temp.bottom;
                l2 = l2.bottom;
            }
        }
        if(l1 != null)
            temp.bottom = l1;
        if(l2 != null)
            temp.bottom = l2;

        return result.bottom;
    }
    // Optimal T -> O(number of nodes)
    public static Node flatten(Node root)
    {
        if(root == null || root.next == null){
            return root;
        }
        root.next = flatten(root.next);

        root = mergeList(root, root.next);

        return root;
    }
}
