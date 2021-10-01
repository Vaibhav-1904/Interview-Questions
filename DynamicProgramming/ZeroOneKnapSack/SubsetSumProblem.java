package ImportantQ.DynamicProgramming.ZeroOneKnapSack;

import java.util.Arrays;

// https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
public class SubsetSumProblem {
//    // Recursive Approach T -> O(2^N)
//    static Boolean isSubsetSum(int N, int arr[], int sum){
//        // code here
//        if(N == 0)
//            return false;
//        if(sum == 0)
//            return true;
//
//        if(arr[N - 1] <= sum)
//            return isSubsetSum(N - 1, arr, sum - arr[N-1]) || isSubsetSum(N-1, arr, sum);
//        else
//            return isSubsetSum(N - 1, arr, sum);
//    }

//    // Memoization DP T -> O(N*sum)
//    static Boolean isSubsetSum(int N, int[] arr, int sum){
//        Boolean[][] dp = new Boolean[N + 1][sum + 1];
//        for(int i = 0; i <= n; i++){
//           dp[i][0] = true;
//        }
//        for(int i = 1; i <= sum; i++){
//            dp[0][i] = false;
//        }
//        return memo(N, arr, sum, dp);
//    }
//
//    static Boolean memo(int N, int[] arr, int sum, Boolean[][] dp){
//
//        if(sum == 0)
//            return dp[N][sum] = true;
//        if(N == 0)
//            return dp[N][sum] = false;
//
//        if(arr[N - 1] <= sum)
//            return dp[N][sum] = memo(N - 1, arr, sum - arr[N-1], dp) || memo(N - 1, arr, sum , dp);
//        else
//            return dp[N][sum] = memo(N - 1, arr, sum, dp);
//    }

//    // T-> O(N*sum)  S->O(n*sum)
//    static Boolean isSubsetSum(int N, int[] arr, int sum) {
//        Boolean[][] dp = new Boolean[N + 1][sum + 1];
//
//        for(int i = 1; i <= sum; i++)
//            dp[0][i] = false;
//
//        for(int i = 0; i <= N; i++)
//            dp[i][0] = true;
//
//        for(int i = 1; i <= N; i++){
//            for(int j = 1; j <= sum; j++){
//                if(arr[i - 1] <= j) {
//                    dp[i][j] = dp[i - 1][j - arr[i-1]] || dp[i - 1][j];
//                }else
//                    dp[i][j] = dp[i - 1][j];
//            }
//        }
//        return dp[N][sum];
//    }

    // Most Optimal
    static Boolean isSubsetSum(int N, int[] nums, int sum){

        boolean[] dp = new boolean[sum + 1];

        for(int i = 0; i < N; i++){
            for(int s = sum; s >= nums[i]; s--){
                if(dp[s - nums[i]] || s == nums[i]) // dp[s - nums[i]] tells if sum was true at s-nums[i],
                    dp[s] = true; // if it was true at that point, then it will be true at current point (s-nums[i]+nums[i])
            }
        }
        return dp[sum];
    }
}
