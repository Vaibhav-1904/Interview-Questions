package ImportantQ.Stack;
// https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
import java.util.Stack;
// Prefix expression notation requires that all operators precede the two operands that they work on.
// Postfix, on the other hand, requires that its operators come after the corresponding operands.
//Infix Expression -> A + B * C + D
//
//Prefix Expression -> + + A * B C D
//
//Postfix Expression -> A B C * + D +
public class InfixPostfix {
    public static int precedence(char c){
        switch(c){
            case '+':
            case '-': return 1;

            case '*':
            case '/': return 2;

            case '^': return 3;

            default: return  - 1;
        }
    }
    // T -> O(n)
    public static String toPostfix(String str){
        String ans = "";
        Stack<Character> stack = new Stack<>();

        for(char i : str.toCharArray()){
            if(Character.isLetterOrDigit(i))
                ans += i;
            else if(i == '('){
                stack.push(i);
            }else if(i == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    ans += stack.pop();
                }
                stack.pop(); // remove (
            }else{
                while(!stack.isEmpty() && precedence(i) <= precedence(stack.peek()))
                    ans += stack.pop();
                stack.push(i);
            }
        }
        while(!stack.isEmpty())
            ans += stack.pop();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(toPostfix("(1+2)*3-4"));
    }
}
