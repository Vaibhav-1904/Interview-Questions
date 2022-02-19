package ImportantQ.Stack;
import java.util.*;
public class StackUsingQueue {
//    // Using 2 Queues
//    Queue<Integer> q1 = new LinkedList<>();
//    Queue<Integer> q2 = new LinkedList<>();
//    public void push(int x) {
//        q2.add(x);
//        while(!q1.isEmpty()){
//            q2.add(q1.remove());
//        }
//        Queue<Integer> temp = q1;
//        q1 = q2;
//        q2 = temp;
//    }
//
//    public int pop() {
//        return q1.remove();
//    }
//
//    public int top() {
//        return q1.element();
//    }
//
//    public boolean empty() {
//        return q1.isEmpty();
//    }

    // Using Single Queue
    Queue<Integer> q = new LinkedList<>();
    public void push(int x) {
        q.add(x);
        int size = q.size() - 1;
        while(size > 0){
            q.add(q.remove());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.remove();
    }
    // remove method return Exception, while poll method returns null.

    /** Get the top element. */
    public int top() {
        return q.element();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
