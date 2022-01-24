package ImportantQ.Strings;

import java.util.Stack;

// https://leetcode.com/problems/basic-calculator/
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int n = s.length();
        int sum = 0;

        for(int i = 0; i < n; i++) {

            char c = s.charAt(i);
            int val = 0;

            if(c == ' ')
                continue;


            if(Character.isDigit(c)){
                while(i < n && Character.isDigit(s.charAt(i))){
                    val = (10 * val) + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                sum = sum + (val*sign);
            }else if(c == '('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;

            }else if(c == ')'){
                sum = sum * stack.pop();
                sum = sum + stack.pop();
            }else if(c == '-')
                sign = -1;
            else
                sign = 1;
        }

        return sum;

    }
}
