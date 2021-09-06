package ImportantQ.LinkedList;
import ImportantQ.LinkedList.ReverseLinkedList.Node;
//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
public class AddTwoNumbers {

    public Node addTwoNumbers(Node l1, Node l2) {

        Node temp = new Node(0);
        Node h1 = l1, h2 = l2;
        Node cur = temp;

        int carry = 0;
        int sum;

        while(h1 != null || h2 != null){
            int x = (h1 == null)?0:h1.val;
            int y = (h2 == null)?0: h2.val;

            sum = carry + x+y;

            if(sum > 9){
                carry = 1;
                sum = sum % 10;
            }else {
                carry = 0;
            }

            cur.next = new Node(sum);
            cur = cur.next;

            if(h1 != null)
                h1 = h1.next;

            if(h2 != null)
                h2 = h2.next;
        }

        if(carry != 0)
            cur.next = new Node(carry);

        return temp.next;
    }

    public static void main(String[] args){

    }
}
