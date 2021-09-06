package ImportantQ.Queue;

import java.util.*;

// Problem: Design a Data Structure a SpecialQueue which supports following operations enque, deque, getMin() or
// getMax() where getMin() operation takes O(1) time.
public class SpecialQueue {
    Queue<Integer> q;
    Deque<Integer> dq;
    public SpecialQueue(){
        q = new LinkedList<>();
        dq = new ArrayDeque<>();
    }
    void enque(int data){
        while(!dq.isEmpty() && data < dq.getLast()){
            dq.removeLast();
        }
        dq.addLast(data);
        q.add(data);
    }
    void deque(int data){
        if(dq.getFirst() == q.peek()){
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
        System.out.println(arr.getMin());
        arr.enque(-1);
        System.out.println(arr.getMin());
    }
}
