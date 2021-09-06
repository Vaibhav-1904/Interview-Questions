package ImportantQ.Stack;

import java.util.Stack;

public class BalancedBrackets {
    static boolean balanceBracket(String str){
        Stack<Character> stack = new Stack<>();
        for(char c :str.toCharArray()){
            if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else if(c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }else if(c == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String str = "()[]{}";

        System.out.println("Balanced Bracket is : " + balanceBracket(str));
    }
}
