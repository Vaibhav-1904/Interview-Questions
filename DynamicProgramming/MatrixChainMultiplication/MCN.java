package ImportantQ.DynamicProgramming.MatrixChainMultiplication;
import java.util.Arrays;
// https://www.youtube.com/watch?v=9uUVFNOT3_Y&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=34
// https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
public class MCN {
    static int matrixMultiplication(int N, int[] arr)
    {
        int[][] dp = new int[N][N];
        for(int[] i : dp)
            Arrays.fill(i, -1);

        return solve(arr, 1, N - 1, dp);
    }

    // Recursive approach
//    static int solve(int[] arr, int i, int j{
//        if(i >= j)
//            return 0;
//
//        int min = Integer.MAX_VALUE;
//        for(int k = i; k + 1 <= j; k++){
//            int temp = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
//            if(temp < min)
//                min = temp;
//        }
//        return min;
//    }

    // Memoization
    static int solve(int[] arr, int i, int j, int[][] dp){
        if(i >= j)
            return dp[i][j] = 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k = i; k + 1 <= j; k++){
            int temp = solve(arr, i, k, dp) + solve(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
            if(temp < min)
                min = temp;
        }
        return dp[i][j] = min;
    }
}
