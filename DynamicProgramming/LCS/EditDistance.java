package ImportantQ.DynamicProgramming.LCS;
// https://leetcode.com/problems/edit-distance/
// https://www.youtube.com/watch?v=8wv_hIRZCRg
import java.util.Arrays;

// s = "geek", t = "gesek"
//Output: 1
public class EditDistance {
    // memoization-Recursive
    public static int editDistance(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        return solve(s, t, 0, 0, dp);
    }
    public static int solve(String s1, String s2, int i, int j, int[][] dp) {
        if(i == s1.length())
            return s2.length() - j;
        if(j == s2.length())
            return s1.length() - i;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = solve(s1, s2, i + 1, j + 1, dp);
        else{
            int insert = 1 + solve(s1, s2, i, j + 1, dp);
            int remove = 1 + solve(s1, s2, i + 1, j, dp);
            int replace = 1 + solve(s1, s2, i + 1, j + 1, dp);

            return dp[i][j] = Math.min(insert, Math.min(remove, replace));
        }
    }

//    // Bottom-Up
//    static int solve(int i, int j, String s1, String s2, int[][]dp){
//
//        if(i<0)
//            return j+1;
//
//        if(j<0)
//            return i+1;
//
//        if(dp[i][j] != -1)
//            return dp[i][j];
//
//        if(s1.charAt(i) == s2.charAt(j)) {
//            return dp[i][j] = solve(i-1, j-1, s1, s2, dp);
//        }
//
//        else { // if both are not same;
//            int insert = 1 + solve(i, j-1, s1, s2, dp);       // insert
//            int remove = 1 + solve(i-1, j, s1, s2, dp);       // remove
//            int replace = 1 + solve(i-1, j-1, s1, s2, dp);  // replace
//            return dp[i][j] = Math.min(insert, Math.min(remove,replace));
//        }

}
