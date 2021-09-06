package ImportantQ.Stack;
import java.util.*;
public class QueueUsingStack {

//    //Using 2 Stacks
//    Stack<Integer> s1 = new Stack<>();
//    Stack<Integer> s2 = new Stack<>();
//    public void push(int x) {
//        while(!s1.isEmpty())
//            s2.push(s1.pop());
//        s1.push(x);
//        while(!s2.isEmpty())
//            s1.add(s2.pop());
//    }
//
//    public int pop() {
//        return s1.pop();
//    }
//
//    public int peek() {
//        return s1.peek();
//    }
//
//    public boolean empty() {
//        return s1.isEmpty();
//    }

    // Using Amortised O(1) push Operation
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if(output.isEmpty()) {
            while (!input.isEmpty())
                output.push(input.pop());
        }
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty())
                output.push(input.pop());
        }
        return output.peek();
    }

    public boolean empty(){
        return (input.isEmpty() && output.isEmpty());
    }
}
