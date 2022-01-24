package ImportantQ.Queue;

import java.util.*;

// Problem: Design a Data Structure a SpecialQueue which supports following operations enqueue, deque, getMin() or
// getMax() where getMin() operation takes O(1) time.
public class SpecialQueue {
    Queue<Integer> q;
    Deque<Integer> dq; // in Deque, the elements are store in ascending order
    public SpecialQueue(){
        q = new LinkedList<>();
        dq = new ArrayDeque<>();
    }
    void enque(int data){
        while(!dq.isEmpty() && data < dq.getLast()) {
            dq.removeLast();
        }
        dq.addLast(data);
        q.add(data);
    }
    void deque(){
        if(dq.getFirst() == q.peek()) { // if min element is to be removed
            dq.removeFirst();
        }
        q.remove();
    }
    int getMin() throws Exception{
        if(q.isEmpty())
            throw new Exception("Queue is Empty");
        else
            return dq.getFirst();
    }

    public static void main(String[] args) throws Exception {
        SpecialQueue arr = new SpecialQueue();
        arr.enque(1);
        arr.enque(2);
        arr.deque();
        System.out.println(arr.getMin());
        arr.enque(-1);
        System.out.println(arr.getMin());
    }
}
