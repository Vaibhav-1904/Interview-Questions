package ImportantQ.LinkedList;
// https://leetcode.com/problems/palindrome-linked-list/submissions/

public class PalindromeLL {
    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) {
              this.val = val;
          }
          ListNode(int val, ListNode next) {
              this.val = val; this.next = next;
          }
  }

  // Naive approach is that copy LinkedList elements in an array and then perform palindrome check.
    // T -> O(n) ,  S -> O(n)


  // Optimal T-> O(n)
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        //Find Middle element
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reversing 2nd half of list
        slow.next = reverseList(slow.next);

        slow = slow.next; //move slow to right half

        // Comparing values
        while(slow != null){
            if(slow.val != head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
