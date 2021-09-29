package ImportantQ.DynamicProgramming.ZeroOneKnapSack;
// Count the number of subset with a given difference
// Eg -> arr ={1,1,2,3}  Difference = 1,
// Ans -> 3
// 1) {1,3} - {2,1}
// 2) {1,3} - {2,1} (since there two 1s)
// 3) {1,1,2} - {3}

public class CountSubset {
    // DP
    static int countSubset(int[] arr, int n, int diff){
        int sum = 0;
        for(int i : arr)
            sum += i;

        int target = (sum - diff) >> 1; // or (sum+diff)/2
        return isSubset(arr, n, target);
    }

    static int isSubset(int[] arr, int n, int sum){

        int[][] dp = new int[n + 1][sum + 1];
        for(int i = 1; i <= sum; i++)
            dp[0][i] = 0;
        for(int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1 , 1, 2, 3};
        System.out.println(countSubset(arr, arr.length, 1));
    }
}
