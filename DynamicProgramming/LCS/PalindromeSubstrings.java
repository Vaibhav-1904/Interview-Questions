package ImportantQ.DynamicProgramming.LCS;
// https://leetcode.com/problems/palindromic-substrings/
// https://www.youtube.com/watch?v=XmSOWnL6T_I
public class PalindromeSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for(int i = 0; i < n; i++){
            String a = "";
            String b = "";
            for(int j = i; j < n; j++){
                String ch = Character.toString(s.charAt(j));
                a += ch;

                b = ch + b;

                if(a.equals(b))
                    count++;
            }
        }

        return count;
    }

//    // DP Solution
//    public int countSubstrings(String str) {
//        int n = str.length();
//        boolean dp[][] = new boolean[n][n];
//        int count = 0;
//
//        // d stands for diagonal
//        for(int d = 0; d < n; d++){
//            for(int i = 0, j = d; j < n; i++, j++) {
//                if(d == 0){
//                    // single char
//                    dp[i][j] = true;;
//                }else if(d == 1){
//                    // 2 characters substring
//                    if(str.charAt(i) == str.charAt(j))
//                        dp[i][j] = true;
//                }else{
//                    // more than 2 characters
//                    if(str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1])
//                        dp[i][j] = true;
//                }
//
//
//                if(dp[i][j])
//                    count++;
//            }
//        }
//        return count;
//    }
}
