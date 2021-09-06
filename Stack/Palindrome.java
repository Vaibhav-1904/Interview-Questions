package ImportantQ.Stack;

import java.util.Stack;

// Check whether the given string is Palindrome using Stack
public class Palindrome {
    static boolean checkPalindrome(String str){
        Stack<Character> stack = new Stack<>();
        char mid = ((str.length() & 1) == 1) ? str.charAt(str.length()>>1) : 'a';

        for(char c: str.toCharArray()){
            if((str.length() & 1) == 1 && mid == c)
                continue;
            else {
                if(!stack.isEmpty() && stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("madam"));
    }
}
