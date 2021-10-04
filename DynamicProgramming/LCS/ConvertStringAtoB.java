package ImportantQ.DynamicProgramming.LCS;
// https://leetcode.com/problems/delete-operation-for-two-strings/
// https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
// Given two strings word1 and word2, return the minimum number of Insertions/Deletions required to make word1 and word2 the same.
//
//In one step, you can delete exactly one character in either string.

// Logic is to
public class ConvertStringAtoB {

    // Naive -> Recursion
//    public static int shortestCommonSupersequence(String s1,String s2,int l1,int l2)
//    {
//        return (s1.length() + s2.length()) - 2*lcs(s1, s2, l1, l2);
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

    // Optimal -> TopDown
    public int minDistance(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

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
        return (s1.length() + s2.length()) - 2*dp[l1][l2];
    }
}
