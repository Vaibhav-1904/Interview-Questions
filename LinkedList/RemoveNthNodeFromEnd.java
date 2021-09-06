package ImportantQ.LinkedList;
import ImportantQ.LinkedList.ReverseLinkedList.Node;
//Given the head of a linked list, remove the nth node from the end of the list and return its head.

public class RemoveNthNodeFromEnd {

//    //Naive
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode temp = head;
//        int size = 0;
//        while(temp != null){
//            size++;
//            temp = temp.next;
//        }
//        temp = head;
//
//        size = size - n;
//        if(size == 0){
//            return head.next;
//        }else{
//            while(size > 1){
//                temp = temp.next;
//                size--;
//            }
//            temp.next = temp.next.next;
//        }
//        return head;
//    }

//    Optimal
    public Node removeNthFromEnd(Node head, int n) {
        Node fast = head;
        Node slow  = head;

        while (n > 0){
            fast = fast.next;
            n--;
        }
        if(fast == null){
            return head.next;
        }
        else {
            while (fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        return head;
    }
}
