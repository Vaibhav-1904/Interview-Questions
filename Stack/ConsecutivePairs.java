package ImportantQ.Stack;
import java.util.Stack;
// https://www.geeksforgeeks.org/check-if-stack-elements-are-pairwise-consecutive/#
public class ConsecutivePairs {
    public static boolean pairWiseConsecutive(Stack<Integer> stack)
    {
        int n = stack.size();
        n = n / 2;

        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()){
            temp.push(stack.pop());
        }
        boolean flag = true;
        while(n > 0){
            stack.push(temp.peek());
            int val1 = temp.pop();

            stack.push(temp.peek());
            int val2 = temp.pop();

            if(Math.abs(val1 - val2) != 1){
                flag = false;
            }
            n--;
        }
        if(!temp.isEmpty()){// last ele
            stack.push(temp.pop());
        }
        return flag;

    }
}
