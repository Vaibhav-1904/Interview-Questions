package ImportantQ.LinkedList;

import java.util.HashMap;
import java.util.HashSet;

// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
// https://leetcode.com/problems/linked-list-cycle-ii/
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
// following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
// is connected to. Note that pos is not passed as a parameter.
// Input: head = [3,2,0,-4], pos = 1
public class CycleLinkedList2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
  }

//  // Naive Approach S -> O(N)
//   public ListNode detectCycle(ListNode head) {
//        if(head == null)
//            return null;
//
//        HashMap<Integer, ListNode> map = new HashMap<>();
//        ListNode temp = head;
//        int i = 0;
//        while(temp != null){
//            if(map.containsValue(temp)){
//                return temp;
//            }else{
//                map.put(i,temp);
//            }
//            temp = temp.next;
//            i++;
//        }
//        return null;
//    }

    // Optimal T -> O(N)
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
