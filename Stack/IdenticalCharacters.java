package ImportantQ.Stack;
import java.util.Stack;
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
// Input: K = 3, str = “qddxxxd”
//Output: q
//Explanation:
//Removal of “xxx” modifies the string to “qddd”.
//Again, removal of “ddd” modifies the string to “q”.
public class IdenticalCharacters {
    static class Pair{
        char c;
        int freq;
        Pair(char c, int f){
            this.c = c;
            freq = f;
        }
    }
    public static String removeIdenticalCharacters(String s, int k){
        if(k == 1)
            return "";

        Stack<Pair> stack = new Stack<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(stack.isEmpty()){
                stack.push(new Pair(s.charAt(i), 1));
                continue;
            }

            if(stack.peek().c == s.charAt(i)){
                Pair p = stack.pop();
                p.freq += 1;
                if(p.freq != k)
                    stack.push(p);
            }else{
                stack.push(new Pair(s.charAt(i), 1));
            }
        }
        String ans = "";
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            while(p.freq > 0){
                ans += p.c;
                p.freq--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(removeIdenticalCharacters("qddxxxd", 3));
    }
}
