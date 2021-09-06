package ImportantQ.Stack;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class AdjacentDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && c == stack.peek())
                stack.pop();
            else
                stack.push(c);
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.empty())
            ans.insert(0,stack.pop());

        return ans.toString();
    }
}
