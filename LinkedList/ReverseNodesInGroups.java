package ImportantQ.LinkedList;
// https://leetcode.com/problems/reverse-nodes-in-k-group/

public class ReverseNodesInGroups {
       public static class ListNode {
           int val;
           ListNode next;
           ListNode() {}
           ListNode(int val) {
               this.val = val;
           }
           ListNode(int val, ListNode next)
           {
               this.val = val;
               this.next = next;
           }
   }

   // T -> O(n + n), S->O(1)
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k == 1)
            return head;

        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        temp = new ListNode(0);
        temp.next = head;

        ListNode pre = temp;
        ListNode cur = temp;
        ListNode nex = temp;

        while(count >= k) {
            cur = pre.next;
            nex = cur.next; // Element whose link is to be reversed
            for(int i = 1; i < k; i++){
                cur.next = nex.next; // To maintain access to nex->next
                nex.next = pre.next; // reversing the link
                pre.next = nex; // to keep track of previous variable whose next element's link has to be reversed
                nex = cur.next; // update nex ->  the element whose link has to be reversed
                                // we cannot use nex.next as cur is used to keep track of nex.next
            }
            pre = cur; // pre has been taken to next group's previous element
            count -= k;
        }
        if(count > 0){
            cur = pre.next;
            nex = cur.next;

            for(int i = 1; i < count; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
        }

        return temp.next; // Since we are not changing temp node it will always point at first element of LL.
    }
}
