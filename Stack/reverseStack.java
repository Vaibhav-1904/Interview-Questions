package ImportantQ.Stack;

import java.util.Stack;

public class reverseStack {

    private static void reverse(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int data = stack.pop();
            reverse(stack);

            insertAtBottom(stack, data);
        }
    }

    static void insertAtBottom(Stack<Integer> stack, int data){
        if(stack.isEmpty())
            stack.push(data);
        else{
            int val = stack.pop();
            insertAtBottom(stack, data);
            stack.push(val);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);

        for(int i:stack) {
            System.out.print(i + " ");
        }
    }
}
