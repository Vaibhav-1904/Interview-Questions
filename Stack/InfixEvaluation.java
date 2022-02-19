package ImportantQ.Stack;

import java.util.Stack;

public class InfixEvaluation {
    // Naive Way to evaluate Infix is to Convert it to Postfix and then Evaluate
    // T -> O(n + n) S -> O(n)

    // Optimal using 2 stacks in 1Pass
    static int infixEvaluate(String str){
        Stack<Integer> digit = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(char c: str.toCharArray()){
            if(c == ' ')
                continue;

            if(Character.isLetterOrDigit(c))
                digit.push(c - '0');
            else if(c == '(')
                operator.push(c);
            else if(c == ')'){
                // Evaluate Bracket
                while(!operator.isEmpty() && operator.peek() != '('){
                    int val1 = digit.pop();
                    int val2 = digit.pop();
                    switch(operator.pop()){
                        case '*': digit.push(val2 * val1);
                            break;
                        case '/': digit.push(val2 / val1);
                            break;
                        case '+': digit.push(val1 + val2);
                            break;
                        case '-': digit.push(val2 - val1);
                    }
                }
                operator.pop();
            }
            else{
                operator.push(c);
            }
        }
        return digit.pop();
    }
}
