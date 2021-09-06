package ImportantQ.Stack;

import java.util.Stack;

public class PreviousSmallerElement {
    public static int[] previousSmallerElements(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[i] <= stack.peek())
                stack.pop();
            if(!stack.isEmpty())
                result[i] = stack.peek();
            else
                result[i] = -1;
            stack.push(arr[i]);
        }
        return result;
    }
}
