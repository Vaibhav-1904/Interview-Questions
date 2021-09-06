package ImportantQ.RecursionBacktracking;
import java.util.*;
// Given a String, Print all the subsequence of given String
public class SubSequence {
    //   // Naive Approach , T->O( 2^n), S -> O(n)
//    public static void printSubSequence(String str, StringBuilder s, int index){
//        if(index == str.length()){
//            System.out.println("{ " + s + " }");
//            return;
//        }
//        printSubSequence(str, new StringBuilder(s), index + 1);
//
//        s.append(str.charAt(index));
//        printSubSequence(str, new StringBuilder(s), index + 1);
//    }

    //Optimised Approach using BitMasking
    // T->O( 2^n * n), space constant
    public static List<String> printSubSequence(String str){
        int n = str.length();
        List<String> ans = new ArrayList<>();

        for(int num = 0; num < (1 << n); num++){ // -> number goes from 0 to 7 if n=3
            String s = "";
            for(int j = 0; j < n; j++){
                if((num & (1<<j)) > 0){
                    s += str.charAt(j);
                }
            }
            ans.add(s);
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        List<String> ans = printSubSequence("abc");
        for(String i:ans)
            System.out.println(i);
    }
}
