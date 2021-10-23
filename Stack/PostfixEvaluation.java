package ImportantQ.Stack;

import java.util.Stack;

public class PostfixEvaluation {
    static int evaluate(String str){
        Stack<Integer> stack = new Stack<>();
        for(char c:str.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(c - '0'); // Character to int
            }else{
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch(c){
                    case '*': stack.push(val2 * val1);
                    break;
                    case '/': stack.push(val2 / val1);
                    break;
                    case '+': stack.push(val1 + val2);
                    break;
                    case '-': stack.push(val2 - val1);
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        System.out.println(evaluate("751*+9-"));
    }
}
