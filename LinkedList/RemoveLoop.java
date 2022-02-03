package ImportantQ.LinkedList;
import ImportantQ.LinkedList.ReverseLinkedList.Node;
import java.util.*;

public class RemoveLoop {
//    // Naive
//    public static void removeLoop(Node head){
//        // code here
//        // remove the loop without losing any nodes
//
//        if(head == null)
//            return;
//
//        Set<Node> set = new HashSet<>();
//        Node pre = null;
//
//        Node temp = head;
//
//        while(temp != null && !set.contains(temp)){
//            pre = temp;
//            set.add(temp);
//            temp = temp.next;
//        }
//
//        if(temp == null)
//            return;
//
//        pre.next = null;
//    }


    // Optimal
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes

        if(head == null)
            return;

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                slow = head;
                if(slow != fast){
                    while(slow.next != fast.next){
                        slow = slow.next;
                        fast = fast.next;
                    }
                }else{
                    // This case is added if fast and slow pointer meet at first position.
                    // If the head node is the point where circular LL starts
                    while(fast.next != slow)
                        fast = fast.next;

                }
                fast.next = null;
                break;
            }
        }
    }
}
