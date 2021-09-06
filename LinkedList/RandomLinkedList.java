package ImportantQ.LinkedList;

import java.util.HashMap;
// https://leetcode.com/problems/copy-list-with-random-pointer/
public class RandomLinkedList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

//    //Naive Approach
//    public Node copyRandomList(Node head) {
//        HashMap<Node, Node> map = new HashMap<>();
//        Node temp = head;
//
//        while(temp != null){
//            Node copy = new Node(temp.val);
//            map.put(temp, copy);
//            temp = temp.next;
//        }
//
//        temp = head;
//        while(temp != null){
//            map.get(temp).next = map.get(temp.next);
//            if(temp.random != null){
//                map.get(temp).random = map.get(temp.random);
//            }else{
//                map.get(temp).random = null;
//            }
//            temp = temp.next;
//        }
//        return map.get(head);
//    }

    // Optimal
    public Node copyRandomList(Node head) {
        Node temp = head;
        // First Step -> Make copy of each Node
        while(temp != null){
            Node deep = new Node(temp.val);
            deep.next = temp.next;
            temp.next = deep;
            temp = temp.next.next;
        }

        temp = head;
        // Second Step -> Assign random pointers of copy Node
        while(temp != null){
            if(temp.random != null)
                temp.next.random = temp.random.next;
            else
                temp.next.random = null;

            temp = temp.next.next;
        }

        // third Step -> Assign next pointers of copy and revert original LinkedList
        temp = head;
        Node newHead = new Node(0);
        Node result = newHead;

        while(temp != null){
            newHead.next = temp.next;
            newHead = newHead.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return result.next;
    }
}
