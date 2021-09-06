package ImportantQ.Bits;
// Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
// ans[i] is the number of 1's in the binary representation of i.

public class CountTotalSetBits {

    // Naive approach is to use for-loop and count total set bits in each element and add them

    //Optimal -> if we need to return sum of set bits
    public static int max2Power(int n){
        int x = 0;
        while((1 << x) <= n)
            x++;

        return x - 1;
    }
    public static int totalSetBits(int n){
        if(n == 0)
            return 0;

        int x = max2Power(n);
        //  Formula -> (2^(x-1) * x) + (n - 2^x + 1) + totalSetBits(n - 2^x)
//        double count = (Math.pow(2,x-1) * x) + (n - Math.pow(2,x) + 1) + totalSetBits(n - (int)Math.pow(2, x));
        int count = ( (1<<(x-1)) * x ) + (n - (1<<x) + 1) + totalSetBits(n - (1<<x));

        return count;
    }

    // If we need to return and array of each number set bits
    public int[] countBits(int n) {

        int[] ans = new int[n+1];
        for(int i = 1;i <= n ;i++){
            ans[i] = ans[ i & (i - 1)] + 1;
        }
        return ans;
    }
}
