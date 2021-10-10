package ImportantQ.DynamicProgramming.LCS;
// https://www.geeksforgeeks.org/longest-repeated-subsequence/
// Eg str = aabebcdd
// Answer = 3(abd)
public class LongestRepeatingSubSequence {

    // Optimal TopDown
    public int LongestRepeatingSubsequence(String str)
    {
        int l = str.length();
        int[][] dp = new int[l + 1][l + 1];

        for(int i = 0; i <= l; i++){
            for(int j = 0; j <= l; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(str.charAt(i - 1) == str.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[l][l];
    }
}
