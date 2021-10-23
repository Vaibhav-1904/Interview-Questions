package ImportantQ.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(),
// isFull() and an additional operation getMin() which should return minimum
// element from the SpecialStack. All these operations of SpecialStack must be O(1).
public class SpecialStack {

//    // O(2N) Space Approach
//    Stack<ArrayList<Integer>> stack;
//    int min;
//    public SpecialStack(){
//        stack = new Stack<>();
//    }
//
//    public void push(int data) {
//        if(stack.isEmpty()){
//            min = data;
//            stack.add(new ArrayList<>(List.of(data, data)));
//        }
//        else{
//            if(data < min){
//                min = data;
//            }
//            stack.push(new ArrayList<>(List.of(data, min)));
//        }
//    }
//
//    public void pop() {
//        stack.pop();
//        if(!stack.isEmpty())
//            min = stack.peek().get(1);
//    }
//
//    public int top() {
//        return stack.peek().get(0);
//    }
//
//    public int getMin() {
//        return stack.peek().get(1);
//    }

    Stack<Long> stack;
    long min;

    public SpecialStack() {
        stack = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int value){
        long val = (long) value;
        if(val < min){
            stack.push(2*val - min);
            min = val;
        }else
            stack.push(val);
    }

    public void pop() {
        if(stack.peek() < min){  // it means topmost element is the minimum element in stack
            min = 2*min - stack.peek();
        }
        stack.pop();
    }

    public int top() {
        long val = stack.peek();
        if(val < min) // It means that topmost element is the minimum element in stack
            return (int)min;
        return (int)val;
    }

    public int getMin() {
        return (int)min;
    }

    public static void main(String[] args){

        SpecialStack s = new SpecialStack();

        s.push(5);
        System.out.println(s.top());
    }

}
