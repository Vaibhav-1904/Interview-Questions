package ImportantQ.LinkedList;
import ImportantQ.LinkedList.ReverseLinkedList.Node;
//Find middle element of LinkedList and print from Middle to end
public class MiddleElement {

//    //Naive
//    public ListNode middleNode(ListNode head) {
//
//        ListNode temp = head;
//        int n = 0; // For counting Number of elements
//        while(temp != null){
//            temp = temp.next;
//            n++;
//        }
//        n = n>>1;
//        while(n > 0){
//            head = head.next;
//            n--;
//        }
//        return head;
//    }

    //Optimal
    public Node middleNode(Node head) {
        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // if(we need the list from 1st middle element if nodes are even then:
//        while(fast.next != null && fast.next.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
        return slow;
    }
}
