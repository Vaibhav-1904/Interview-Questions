package ImportantQ.DynamicProgramming;
// https://leetcode.com/problems/interleaving-string/
public class InterleavingStrings {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;

        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];

        return solve(s1, s2, s3, s1.length(), s2.length(), s3.length(), dp);
    }

    public boolean solve(String s1, String s2, String s3, int i, int j, int k, Boolean[][] dp) {

        if(i == 0 && j == 0 && k == 0)
            return true;

        if(k == 0 && (i != 0 || j != 0))
            return false;

        if(k != 0 && (i == 0 && j == 0))
            return false;

        if(dp[i][j] != null)
            return dp[i][j];

        if(i != 0 && j != 0 && s1.charAt(i - 1) == s3.charAt(k - 1) && s2.charAt(j - 1) == s3.charAt(k - 1))
            return dp[i][j] = solve(s1, s2, s3, i - 1,j, k - 1, dp) || solve(s1, s2, s3, i,j - 1, k - 1, dp);
        else if(i != 0 && s1.charAt(i - 1) == s3.charAt(k - 1))
            return dp[i][j] = solve(s1, s2, s3, i - 1, j, k - 1, dp);
        else if(j != 0 && s2.charAt(j - 1) == s3.charAt(k - 1))
            return dp[i][j] = solve(s1, s2, s3, i, j - 1, k - 1, dp);
        else
            return false;
    }
}
