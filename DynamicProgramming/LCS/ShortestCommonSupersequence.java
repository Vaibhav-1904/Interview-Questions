package ImportantQ.DynamicProgramming.LCS;
// https://www.geeksforgeeks.org/shortest-common-supersequence/
// You are given 2 different strings, you need to return length of supersequence of both strings
// A supersequence of 2strings is a string from which both the child strings can be formed.

// Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
// Output:  9
// Explanation:
// String "AGXGTXAYB" has both string
// "AGGTAB" and "GXTXAYB" as subsequences.

// We observe the pattern that : length(supersequence) = sumOfLength(s1 + s2) - LCS(s1, s2)
// LCS is the longest common subsequence

public class ShortestCommonSupersequence {
//    // Naive -> Recursion
//    public static int shortestCommonSupersequence(String s1,String s2,int l1,int l2)
//    {
//        return (s1.length() + s2.length()) - lcs(s1, s2, l1, l2);
//    }
//
//    static int lcs(String s1,String s2,int l1,int l2){
//        if(l1 == 0 || l2 == 0)
//            return 0;
//
//        if(s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
//            return 1 + lcs(s1, s2, l1 - 1, l2 - 1);
//        else
//            return Math.max(lcs(s1, s2, l1 - 1, l2), lcs(s1, s2, l1, l2 - 1));
//    }

    //Optimal -> TopDown
    public static int shortestCommonSupersequence(String s1, String s2, int l1, int l2)
    {
        int[][] dp = new int[l1 + 1][l2 + 1];
        for(int i = 0; i <= l1; i++){
            for(int j = 0; j <= l2; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return (s1.length() + s2.length()) - dp[l1][l2];
    }
}
