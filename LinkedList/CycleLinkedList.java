package ImportantQ.LinkedList;
import ImportantQ.LinkedList.ReverseLinkedList.Node;
//Given head, the head of a linked list, determine if the linked list has a cycle in it.
// https://leetcode.com/problems/linked-list-cycle/
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
// following the next pointer.
// Internally, pos is used to denote the index of the node that tail's next pointer
// is connected to. Note that pos is not passed as a parameter.
//
//Return true if there is a cycle in the linked list. Otherwise, return false.

public class CycleLinkedList {

    //Naive Approach
//    public boolean hasCycle(ListNode head) {
//
//        if(head == null)
//            return false;
//
//        HashSet<ListNode> h = new HashSet<>();
//
//        while(true){
//
//            if(h.contains(head))
//                return true;
//            else{
//                h.add(head);
//                head = head.next;
//            }
//
//            if(head == null)
//                return false;
//        }
//    }

    // Optimal S -> O(n)
    public boolean hasCycle(Node head){
        if(head == null || head.next == null)
            return false;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast)
                return true;
        }
        return false;
    }

}
