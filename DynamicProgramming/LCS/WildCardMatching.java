package ImportantQ.DynamicProgramming.LCS;
//https://www.geeksforgeeks.org/wildcard-pattern-matching/
// https://www.geeksforgeeks.org/dynamic-programming-wildcard-pattern-matching-linear-time-constant-space/
// Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds
// if wildcard pattern is matched with text. The matching should cover the entire text (not partial text).
//The wildcard pattern can include the characters ‘?’ and ‘*’
//‘?’ – matches any single character
//‘*’ – Matches any sequence of characters (including the empty sequence)

public class WildCardMatching {
    //Naive Approach
//    public boolean isMatch(String s, String p) {
//        int l1 = s.length();
//        int l2 = p.length();
//        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
//
//        for(int i = 0; i <= l1; i++)
//            dp[i][0] = false;
//        dp[0][0] = true;
//        for(int j = 1; j <= l2; j++){
//            if(p.charAt(j - 1) == '*')
//                dp[0][j] = dp[0][j - 1];
//            else
//                dp[0][j] = false;
//        }
//
//        for(int i = 1; i <= l1; i++){
//            for(int j = 1; j <= l2; j++){
//                //// If current characters match, result is same as
//                //// result for lengths minus one. Characters match
//                //// in two cases:
//                //// a. If pattern character is '?' then it matches
//                ////    with any character of text.
//                //// b. If current characters in both match
//                if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?')
//                    dp[i][j] = dp[i - 1][j - 1];
//                    // If we encounter ‘*’, two choices are possible-
//                    // a) We ignore ‘*’ character and move to next
//                    //    character in the pattern, i.e., ‘*’
//                    //    indicates an empty sequence.
//                    // b) '*' character matches with ith character in
//                    //     input
//                else if(p.charAt(j - 1) == '*')
//                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
//                else
//                    dp[i][j] = false;
//            }
//        }
//        return dp[l1][l2];
//    }

    // Optimal
    public boolean isMatch(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();
        int i = 0, j = 0;
        int index_txt = -1, index_p = -1;

        while(i < l1){
            if(j < l2 && s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else if(j < l2 && p.charAt(j) == '?'){
                i++;
                j++;
            }else if(j < l2 && p.charAt(j) == '*'){
                index_txt = i;
                index_p = j;
                j++;
            }else if(index_p != - 1){
                i = index_txt + 1;
                j = index_p + 1;
                index_txt++;
            }else{
                return false;
            }
        }

        while(j < l2 && p.charAt(j) == '*')
            j++;

        return j == l2;
    }

}
