package ImportantQ.LinkedList;
// Given the head of a linked list, rotate the list to the right by k places.
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

//https://leetcode.com/problems/rotate-list/
public class RotateList {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
//    // Naive T->O(n + n*k)
//    public ListNode rotateRight(ListNode head, int k) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        int count = 0;
//        ListNode temp = head;
//        while(temp != null){
//            count++;
//            temp = temp.next;
//        }
//        k = k % count; //Optimizing k if needed
//
//        while(k > 0){
//            temp = head;
//            ListNode pre = head;
//            while(temp.next != null && pre.next.next != null){
//                temp = temp.next;
//                pre = pre.next;
//            }
//            temp = pre.next;
//
//            ListNode newHead = new ListNode(temp.val); // Rotating
//            newHead.next = head;
//            head = newHead; // Creating new Head
//
//            pre.next = null;
//            k--;
//        }
//        return head;
//    }

    // Optimal T -> O(n + (n-k))
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        int len = 1;
        ListNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
            len++;
        }
        temp.next = head; // Creating Circular LinkedList
        k = k % len; // Optimizing k if k > len
        k = len - k; // Point where link has to be broken
        temp = head;
        while(k > 1){
            k--;
            temp = temp.next;
        }
        head = temp.next; // New head
        temp.next = null; // Breaking Circular LinkedList

        return head;
    }
}
