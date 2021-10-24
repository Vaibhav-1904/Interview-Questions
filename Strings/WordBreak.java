package ImportantQ.Strings;
import java.util.*;
// https://leetcode.com/problems/word-break/
public class WordBreak {
//    // recursion
//    public boolean wordBreak(String s, List<String> dict) {
//        int n = s.length();
//
//        if(dict.contains(s))
//            return true;
//
//        for(int i = 1; i <= n; i++){
//            if(dict.contains(s.substring(0, i)) && wordBreak(s.substring(i, n), dict))
//                return true;
//        }
//        return false;
//    }


    // optimal T->O(n^2)
    public boolean wordBreak(String s, List<String> dictionary) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dictionary.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
