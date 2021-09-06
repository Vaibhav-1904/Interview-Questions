package ImportantQ.LinkedList;
import ImportantQ.LinkedList.ReverseLinkedList.Node;
//Given the heads of two singly linked-lists headA and headB,
// return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

public class IntersectionLinkedList {

    public Node getIntersectionNode(Node h1, Node h2) {

        Node temp1 = h1;
        Node temp2 = h2;

        while(true){

            if(temp1 == temp2)
                return temp1;

            if(temp1 == null && temp2 == null)
                break;

            if(temp1 == null){
                temp1 = h2;
            }else{
                temp1 = temp1.next;
            }

            if(temp2 == null){
                temp2 = h1;
            }else{
                temp2 = temp2.next;
            }
        }
        return null;
    }

}
