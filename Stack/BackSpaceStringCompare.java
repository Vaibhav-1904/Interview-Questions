package ImportantQ.Stack;

import java.util.Stack;

// https://leetcode.com/problems/backspace-string-compare/
public class BackSpaceStringCompare {
//    // Naive
//    public boolean backspaceCompare(String s, String t) {
//
//        Stack<Character> stack1 = new Stack<>();
//        Stack<Character> stack2 = new Stack<>();
//
//        for(char c : s.toCharArray()) {
//            if(c != '#')
//                stack1.push(c);
//            else if(!stack1.isEmpty())
//                stack1.pop();
//        }
//
//        for(char c : t.toCharArray()) {
//            if(c != '#')
//                stack2.push(c);
//            else if(!stack2.isEmpty())
//                stack2.pop();
//        }
//
//        while(!stack1.isEmpty()) {
//            char c = stack1.pop();
//
//            if(stack2.isEmpty() || stack2.pop() != c)
//                return false;
//        }
//
//        return stack1.isEmpty() && stack2.isEmpty();
//    }

    // Optimal
    public boolean backspaceCompare(String s, String t) {

        int i = s.length() - 1;
        int j = t.length() - 1;

        int c1 = 0, c2 = 0;

        while(i >= 0 || j >= 0) {
            while((i >= 0 && s.charAt(i) == '#') || c1 > 0) {
                if(i >= 0 && s.charAt(i) == '#')
                    c1++;
                else
                    c1--;

                i--;
            }

            while((j >= 0 && t.charAt(j) == '#') || c2 > 0) {
                if(j >= 0 && t.charAt(j) == '#')
                    c2++;
                else
                    c2--;

                j--;
            }

            if(i < 0 && j < 0)
                return true;

            if(i < 0 || j < 0)
                return false;

            if(s.charAt(i--) != t.charAt(j--))
                return false;
        }
        return true;
    }
}
