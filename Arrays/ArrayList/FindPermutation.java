package ImportantQ.Arrays.ArrayList;
import java.util.ArrayList;
import java.util.Stack;
// Given a positive integer n and a string s consisting only of letters D or I,
// you have to find any permutation of first n positive integer that satisfy the given input string.
//
// D means the next number is smaller, while I mean the next number is greater.
// Length of given string s will always equal to n - 1

// Eg Input 1:
//
//n = 3
//
//s = ID
//
//Return: [1, 3, 2]
// https://www.interviewbit.com/problems/find-permutation/

public class FindPermutation {
////     Better Solution t -> O(N + N), S->O(N)
//    public static ArrayList<Integer> findPerm(final String str, int B) {
//        int n = str.length();
//        int count = 0;
//        ArrayList<Integer> ans = new ArrayList<>();
//        Stack<Integer> stack = new Stack<>();
//
//        for(int i = 0; i < n; i++){
//            count++;
//            stack.push(count);
//            if(str.charAt(i) == 'I'){
//                while(!stack.isEmpty()) {
//                    ans.add(stack.peek());
//                    stack.pop();
//                }
//            }
//        }
//        stack.push(count + 1);
//        while(!stack.isEmpty()){
//            ans.add(stack.peek());
//            stack.pop();
//        }
//        return ans;
//    }

    // Optimal
    public static ArrayList<Integer> findPermutation(String str, int B ) {
        int n = str.length();
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 1;
        int end = 0;
        for(int i = 0; i < n; i++){
            end++;
            if(str.charAt(i) == 'I') {
                for(int j = end; j >= start; j--)
                    ans.add(j);

                start = end + 1;
            }
        }
        end++;
        for(int j = end; j >= start; j--)
            ans.add(j);

        return ans;
    }
}
