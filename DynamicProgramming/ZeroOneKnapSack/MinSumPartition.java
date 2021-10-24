package ImportantQ.DynamicProgramming.ZeroOneKnapSack;
import java.util.ArrayList;
// Given an array arr, you need to divide array into 2 subsets such that difference of
// sum of 2 subsets should be minimum. -> Minimize(sum1-sum2)
// https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
public class MinSumPartition {
    // T-> O(2^n)
//    public int minDifference(int[] arr, int n) {
//        int sum = 0;
//        for(int i : arr)
//            sum += i;
//
//        return findMinDif(arr, n, 0, sum);
//    }
//
//    int findMinDif(int[] arr, int n, int sumTillNow, int sum){
//        if(n == 0){
//            return Math.abs((sum - sumTillNow) - sumTillNow);
//        }
//
//        return Math.min(findMinDif(arr, n - 1, sumTillNow + arr[n - 1], sum), findMinDif(arr, n - 1, sumTillNow, sum));
//    }

    // T-> O(sum*N) S->O(sum*n)
    public int minDifference(int[] arr, int n)
    {
        int sum = 0;
        for(int i : arr)
            sum += i;

        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        isSubsetSum(n, arr, sum, dp);// we want all the subset sums which are possible with this array,
        // since we want to minimize(sum2 - sum1), our sum1 will lie in range from 0->sum
        // and sum2 = sum - sum1, once we get a boolean array of size(sum) which contains details of all sum subsets
        // present int th array arr, we go further

        ArrayList<Integer> list = new ArrayList<>();
        // In list, we store all the elements upto sum/2 because our sum1 will be at max sum/2.
        // It cannot exceed sum/2.
        for(int i = 0; i <= sum/2 ; i++){
            if(dp[n][i]){
                list.add(i);
            }
        }
        // Then we calculate the minimum value possible
        int min = Integer.MAX_VALUE;
        for(int i : list){// i is sum1
            min = Math.min(min, (sum - i) - i); // sum2 - sum1
        }

        return min;
    }

    static void isSubsetSum(int N, int[] arr, int sum, Boolean[][] dp) {

        for(int i = 1; i <= sum; i++)
            dp[0][i] = false;

        for(int i = 0; i <= N; i++)
            dp[i][0] = true;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i-1]] || dp[i - 1][j];
                }else
                    dp[i][j] = dp[i - 1][j];
            }
        }
    }

}