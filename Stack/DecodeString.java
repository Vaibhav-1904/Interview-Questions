package ImportantQ.Stack;
import java.util.Stack;
// https://www.geeksforgeeks.org/decode-string-recursively-encoded-count-followed-substring/
// Input : str[] = "3[b2[ca]]"
//Output : bcacabcacabcaca


public class DecodeString {
    //Naive Approach T->O(n) S->O(2n)
//    static String Decode(String str) {
//        Stack<Integer> stack = new Stack<>();
//        Stack<Character> stringStack = new Stack<>();
//        StringBuilder result = new StringBuilder();
//
//        for(int i = 0; i < str.length(); i++) {
//            int count = 0;
//            if(Character.isDigit(str.charAt(i))) {
//                while(Character.isDigit(str.charAt(i))){
//                    count = (10 * count) + str.charAt(i) - '0';
//                    i++;
//                }
//                i--;
//                stack.push(count);
//            }else if(str.charAt(i) == ']'){
//
//                StringBuilder temp = new StringBuilder();
//                while(!stringStack.empty() && stringStack.peek() != '['){
//                    temp.append(stringStack.pop());
//                }
////                temp = temp.reverse();
//
//                if(!stringStack.isEmpty() && stringStack.peek() == '[')
//                    stringStack.pop();
//
//                count = stack.pop();
//
//                while(count > 0){
//                    result.append(temp);
//                    count--;
//                }
//
//                for(int j = 0; j < result.length(); j++) {
//                    stringStack.push(result.charAt(j));
//                }
//                result = new StringBuilder();
//
//            }else{
//                stringStack.push(str.charAt(i));
//            }
//        }
//
//        while(!stringStack.isEmpty()){
//            result.append(stringStack.pop());
//        }
//        return result.toString();
//    }

    // optimal
    static String Decode(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ']'){
                StringBuilder temp = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '['){
                    temp.append(stack.pop());
                }

                stack.pop();
                int digit = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    digit = (digit * 10) + Integer.parseInt(String.valueOf(stack.pop()));
                }

                while(digit > 0){
                    result.append(temp);
                    digit--;
                }

                for(int j = 0; j < result.length(); j++) {
                    stack.push(result.charAt(j));
                }
                result = new StringBuilder();

            }else
                stack.push(str.charAt(i));
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Decode("3[b2[ca]]"));
    }
}
