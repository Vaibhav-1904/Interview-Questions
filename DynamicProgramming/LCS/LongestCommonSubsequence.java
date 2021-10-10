package ImportantQ.DynamicProgramming.LCS;
// Given 2 Strings, find th length of the longest common subsequence in them
public class LongestCommonSubsequence {

//    // Recursive Approach
//    static int lcs(String s1, String s2, int l1, int l2){
//        if(l1 == 0 || l2 == 0)
//            return 0;
//
//        if(s1.charAt(l1 - 1) == s2.charAt(l2 - 1)){
//            return 1 + lcs(s1, s2, l1 - 1, l2 - 1);
//        }else{
//            return Math.max(lcs(s1, s2, l1 - 1, l2), lcs(s1, s2, l1, l2 - 1)) ;
//        }
//    }

//    // memoization Bottom-Up T->O(l1*l2)
//    static int lcs(String s1, String s2, int l1, int l2){
//        int[][] dp = new int[l1 + 1][l2 + 1];
//        for(int i = 0; i < s1.length(); i++){
//            for(int j = 0; j <= s2.length(); j++)
//                dp[i][j] = -1;
//        }
//
//        return findMax(s1, s2, l1, l2, dp);
//    }
//    static int findMax(String s1, String s2, int l1, int l2, int[][] dp){
//        if(l1 == 0 || l2 == 0)
//            return 0;
//        if(dp[l1 - 1][l2 - 1] != -1)
//            return dp[l1 - 1][l2 - 1];
//
//        if(s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
//            return dp[l1 - 1][l2 - 1] = 1 + findMax(s1, s2, l1 - 1, l2 - 1, dp);
//        else
//            return dp[l1 - 1][l2 - 1] = Math.max(findMax(s1, s2, l1, l2 - 1, dp), findMax(s1, s2, l1 - 1, l2, dp));
//    }

    // Top-Down Approach T-> O(l1*l2)
    static int lcs(String s1, String s2, int l1, int l2){
        // d -> diagonal, h -> horizontal, v -> vertical
        int[][] dp = new int[l1 + 1][l2 + 1];

        for(int i = 0; i <= l2; i++)
            dp[0][i] = 0;
        for(int i = 0; i <= l1; i++)
            dp[i][0] = 0;

        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // For Printing LCS
        int i = l1;
        int j = l2;
        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                System.out.print(s1.charAt(i - 1));
                i--;
                j--;
            }else{
                if(dp[i - 1][j] < dp[i][j - 1])
                    j--;
                 else
                    i--;
            }
        }
        System.out.println();
        return dp[l1][l2];
    }


    public static void main(String[] args) {
        String s1 = "pqrbde"; // pbde
        String s2 = "pabcdef";

        System.out.println(lcs(s1, s2, s1.length(), s2.length()));
    }
}
