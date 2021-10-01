package ImportantQ.DynamicProgramming.UnBoundedKnapSack;
// https://www.geeksforgeeks.org/maximize-the-number-of-segments-of-length-p-q-and-r/
// Given an integer N denoting the Length of a line segment. You need to cut the line segment in such a way that
// the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
// After performing all the cut operations, your total number of cut segments must be maximum.
// Input: N = 11, x = 2, y = 3, z = 5
//Output: 5
//Segments of 2, 2, 2, 2 and 3
public class MaximizeCutSegments {

//    // Recursive
//    public int maximizeCuts(int n, int x, int y, int z)
//    {
//        //Your code here
//        if(n == 0) return 0;
//
//        int one = Integer.MIN_VALUE;
//        int two = Integer.MIN_VALUE;
//        int three = Integer.MIN_VALUE;
//
//        if(x <= n) one = maximizeCuts(n - x, x, y, z);
//        if(y <= n) two = maximizeCuts(n - y, x, y, z);
//        if(z <= n) three = maximizeCuts(n - z, x, y, z);
//
//        return 1 + Math.max(one, Math.max(two, three));
//    }

    // //Better Approach Memoization
    // public int maximizeCuts(int n, int x, int y, int z)
    // {
    //     int[] dp = new int[n + 1];
    //     for(int i = 0; i <= n; i++){
    //         dp[i] = -1;
    //     }

    //     int ans = maximize(n, x, y, z, dp);

    //     if(ans < 0) return 0;

    //     return ans;
    // }

    // int maximize(int n, int x, int y, int z, int[] dp) {
    //     if(n == 0) 
    //         return 0;

    //     if(dp[n] != -1)
    //         return dp[n];

    //     int one = Integer.MIN_VALUE;
    //     int two = Integer.MIN_VALUE;
    //     int three = Integer.MIN_VALUE;

    //     if(x <= n) one = maximize(n - x, x, y, z, dp);
    //     if(y <= n) two = maximize(n - y, x, y, z, dp);
    //     if(z <= n) three = maximize(n - z, x, y, z, dp);

    //     return dp[n] = 1 + Math.max(one, Math.max(two, three));
    // }

//    // Dynamic Programming
   public int maximizeCuts(int n, int x, int y, int z)
   {
       int[] dp = new int[n + 1]; // It denoted total cuts at length form 0->n
       for(int i = 0;i <= n; i++){
           dp[i] = -1;
       }
       // if length of rod is 0
       // then total cuts will
       // be 0 so, initialize
       // the dp[0] with 0
       dp[0] = 0;

       for(int i = 0; i <= n; i++){

           // if certain length
           // is not possible
           if(dp[i] == -1 )
               continue;

           if(i + x <= n)
               dp[i + x] = Math.max(dp[i + x], dp[i] + 1);
           if(i + y <= n)
               dp[i + y] = Math.max(dp[i + y], dp[i] + 1);
           if(i + z <= n)
               dp[i + z] = Math.max(dp[i + z], dp[i] + 1);
       }
       if(dp[n] == -1)
           dp[n] = 0;

       return dp[n];
   }
}
