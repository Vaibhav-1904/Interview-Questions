package ImportantQ.Stack;
// https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
import java.util.Stack;

public class InfixPostfix {
    public static int precedence(char c){
        switch(c){
            case '+':
            case '-': return 1;

            case '*':
            case '/': return 2;

            case '^':return 3;
        }
        return -1;
    }
    // T -> O(n)
    public static String toPostfix(String str){
        String ans = "";
        Stack<Character> stack = new Stack<>();

        for(char i:str.toCharArray()){
            if(Character.isLetterOrDigit(i))
                ans += i;
            else if(i == '('){
                stack.push(i);
            }else if(i == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    ans += stack.pop();
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && precedence(i) < precedence(stack.peek()))
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
