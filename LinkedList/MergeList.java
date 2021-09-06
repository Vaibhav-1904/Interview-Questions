package ImportantQ.LinkedList;
import ImportantQ.LinkedList.ReverseLinkedList.Node;
// Merge two sorted linked lists and return it as a sorted list. The list should be made by
// splicing together the nodes of the first two list
public class MergeList {

//    //Naive
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode h1 = l1;
//        ListNode h2 = l2;
//        ListNode head = new ListNode(0);
//        ListNode cur = head;
//
//        while(true){
//            if(h1 == null){
//                cur.next = h2;
//                break;
//            }
//            if(h2 == null){
//                cur.next = h1;
//                break;
//            }
//            if(h1.val < h2.val){
//                cur.next = h1;
//                h1 = h1.next;
//            }else{
//                cur.next = h2;
//                h2 = h2.next;
//            }
//            cur = cur.next;
//        }
//        return head.next;
//    }

    //Optimal  T -> O(n1+n2) S -> O(1)
    public Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        if(l2.val < l1.val){
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        Node head = l1;

        while(l1 != null && l2 != null){
            Node temp = null;
            while(l1 != null && l1.val <= l2.val){
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2; // You need to break the Link when number in 2nd list(l2) is smaller than l1.
                            // Connect the link to the second list where current element is smaller in l2.

            //swap
            Node swap = l1;
            l1 = l2;
            l2 = swap;
        }
        return head;
    }

}
