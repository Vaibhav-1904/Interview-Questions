package ImportantQ.DynamicProgramming.LCS;

public class LongestCommonSubString {
    // For Recursive and Memoization approach, you need to carry a variable count which has count of
    // max substring length till now in recursive function.

    // Top-Down
    static int longestCommonSubstr(String s1, String s2, int l1, int l2){
        int[][] dp = new int[l1 + 1][l2 + 1];

        int max = 0;
        for(int i = 0; i <= l1; i++) {
            for(int j = 0; j <= l2; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }else
                    dp[i][j] = 0;
            }
        }
        int i = l1;
        int j = l2;
        while(i > 0) {
            if(j == 0)
                j = l2;
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                System.out.print(s1.charAt(i - 1));
                i--;
                j--;
            } else
                j--;
        }
        System.out.println();
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstr("GeeksforGeeks", "GeeksQuiz", 13, 9));
    }
}
