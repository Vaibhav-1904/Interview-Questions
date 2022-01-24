package ImportantQ.DynamicProgramming.ZeroOneKnapSack;

import java.util.Arrays;

// Count number of subsets which are equal to given sum
// https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
public class CountSubsetForSum {
//    // Recursive T->O(2^n)
//    static int countSubset(int[] arr, int sum, int n){
//        if(sum == 0 && n == 0)
//            return 1;
//        if(n == 0)
//            return 0;
//
//        return countSubset(arr, sum - arr[n - 1], n-1) + countSubset(arr, sum, n-1);
//    }

//    // DP T->O(sum*n)
//    static int countSubset(int[] arr, int sum, int n){
//        int[][] dp = new int[n + 1][sum + 1];
//
//        for(int i = 1; i <= sum; i++)
//            dp[0][i] = 0;
//        for(int i = 0; i <= n; i++)
//            dp[i][0] = 1;
//
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= sum; j++){
//                if(arr[i - 1] <= j)
//                    dp[i][j] = dp[i-1][j] + dp[i - 1][j - arr[i - 1]];
//                else
//                    dp[i][j] = dp[i - 1][j];
//            }
//        }
//        return dp[n][sum];
//    }

    // DP T->O(sum)
    static int countSubset(int[] arr, int sum, int n) {
        int[] dp = new int[sum + 1];

        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = sum; j >= arr[i]; j--){
                if(dp[j - arr[i]] != 0 || j == arr[i])
                    dp[j] += dp[j - arr[i]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};

        System.out.println(countSubset(arr, 10, arr.length));
    }
}
