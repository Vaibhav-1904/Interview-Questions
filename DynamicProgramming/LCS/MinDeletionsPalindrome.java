package ImportantQ.DynamicProgramming.LCS;
// https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
public class MinDeletionsPalindrome {
    // Naive Approach -> Recursion

    // Optimal -> TopDown
    static int minimumNumberOfDeletions(String s) {
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
        return s.length() - dp[l][l];
    }
}
