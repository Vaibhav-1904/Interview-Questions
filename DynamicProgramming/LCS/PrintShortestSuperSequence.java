package ImportantQ.DynamicProgramming.LCS;
// https://leetcode.com/problems/shortest-common-supersequence/
public class PrintShortestSuperSequence {
    // Top-Down Optimal
    public String shortestCommonSupersequence(String s1, String s2) {
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

        StringBuilder result = new StringBuilder();
        int i = l1, j = l2;
        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                result.append(s1.charAt(i - 1));
                i--;
                j--;
            }else{
                if(dp[i - 1][j] > dp[i][j - 1]) {
                    result.append(s1.charAt(i - 1));
                    i--;
                }
                else {
                    result.append(s2.charAt(j - 1));
                    j--;
                }
            }
        }
        while(i > 0){
            result.append(s1.charAt(i - 1));
            i--;
        }
        while(j > 0){
            result.append(s2.charAt(j - 1));
            j--;
        }
        return result.reverse().toString();
    }
}
