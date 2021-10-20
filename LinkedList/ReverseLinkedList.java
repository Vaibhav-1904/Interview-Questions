package ImportantQ.LinkedList;

// https://leetcode.com/problems/reverse-linked-list/

public class ReverseLinkedList {

    public static class Node {
      int val;
      Node next;
      Node() {

      }
      Node(int val) {
          this.val = val;
      }
      Node(int val, Node next) {
          this.val = val;
          this.next = next;
      }
  }

    public Node reverseList(Node head)
    {
        Node newHead = null;

        while(head != null){
            Node next = head.next;
            head.next = newHead; // pointing towards left side(reverse)
            newHead = head;
            head = next;
        }

        return newHead;
    }

}
