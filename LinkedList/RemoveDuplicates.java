package ImportantQ.LinkedList;
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicates {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode temp = new ListNode(0);
        ListNode pre = temp;
        pre.next = head;

        ListNode cur = head.next;

        while(cur != null) {
            boolean flag = false;

            while(cur != null && cur.val == pre.next.val) {
                cur = cur.next;
                flag = true;
            }

            if(flag){
                pre.next = cur;
                if(cur != null)
                    cur = cur.next;
            }else{
                pre = pre.next;
                pre.next = cur;
                cur = cur.next;
            }
        }
        return temp.next;
    }
}
