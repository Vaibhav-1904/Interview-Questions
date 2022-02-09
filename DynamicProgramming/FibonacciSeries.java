package ImportantQ.DynamicProgramming;

public class FibonacciSeries {
//    // recursive
//    int fib(int n)
//    {
//        if (n <= 1)
//            return n;
//
//        return fib(n-1) + fib(n-2);
//    }

//    // DP -> Tabulation
//    int fib(int n)
//    {
//        // Declare an array to store Fibonacci numbers
//        int[] dp = new int[n + 2];   // 1 extra to handle case, n = 0
//        int i;
//
//        // 0th and 1st number of the series are 0 and 1
//        dp[0] = 0;
//        dp[1] = 1;
//
//        for (i = 2; i <= n; i++)
//        {
//            // Add the previous 2 numbers in the series
//            // and store it
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        return dp[n];
//    }

    // Optimal
    static int fib(int n) {

        if(n <= 1)
            return n;

        int prev;
        int prev2 = 0;
        int result = 1;
        for(int i = 2; i <= n; i++) {
            prev = result;
            result = prev + prev2;
            prev2 = prev;
        }
        return result;
    }

    public static void main(String[] args) {

        for(int i = 0; i < 10; i++) {
            System.out.print(fib(i) + "  ");
        }
    }
}
