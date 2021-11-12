package ImportantQ.RecursionBacktracking;
// Count ways to reach the nth stair using step 1, 2 or 3.
// A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
// Implement a method to count how many possible ways the child can run up the stairs.
//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    static int count = 0;
//    T -> 3^n, Naive Approach
//    public static int countPossibleWays(int n){
//        count++;
//        if(n < 0)
//            return 0;
//        else if(n == 0)
//            return 1;
//
//        return countPossibleWays(n - 1) + countPossibleWays(n - 2) + countPossibleWays(n - 3);
//    }

    //Optimal Approach
    // Create an array of size n + 1 and initialize the first 3 variables with 1, 1, 2. The base cases.
    //Run a loop from 3 to n.
    //For each index i, computer value of ith position as dp[i] = dp[i-1] + dp[i-2] + dp[i-3].
    //Print the value of dp[n], as the Count of the number of ways to reach n th step.
    public static int countPossibleWays(int n)
    {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2] + res[i - 3];

        return res[n];
    }

    public static void main(String[] args) {
        System.out.println("Steps Count is  : " + countPossibleWays(4));
        System.out.println("Count : " + count);
    }
}
