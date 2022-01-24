package ImportantQ.DynamicProgramming.LCS;
//https://leetcode.com/problems/longest-palindromic-subsequence/
public class LongestPalindromicSubsequence {
    // Naive Approach -> Recursion

    // topDown Optimal
    public static int longestPalindromeSubSeq(String s) {
        StringBuilder s1 = new StringBuilder(s);
        String s2 = s1.reverse().toString();
        int l = s.length();
        int[][] dp = new int[l + 1][l + 1];

        for(int i = 0; i <= l; i++){
            for(int j = 0; j <= l; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(s.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[l][l];
    }

    public static void main(String[] args) {
        String a = "bbbab";
        System.out.println(longestPalindromeSubSeq(a));
    }
}
