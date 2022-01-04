package ImportantQ.BitManipulation;
// https://leetcode.com/problems/divide-two-integers/
public class DivideIntegers {

    // Optimal T-> O(32)
    public int divide(int dividend, int divisor) {
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1; // if both are -ve or both are +ve the 1
        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        long t = 0;
        long quotient = 0;

        for(long i = 31; i >= 0; i--) {
            if(( t + (n << i) ) <= m) {  // n<<i means n * 2^i
                t += (n << i);
                quotient += (1L << i);
            }
        }
        if(sign == -1)
            quotient = -1 * quotient;

        if(quotient >= Integer.MAX_VALUE || quotient < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;// edge case // dividend = -2147483648
                                                    //divisor = -1

        return (int)quotient;
    }

//    // Naive T-> O(dividend)
//    public int divide(int dividend, int divisor) {
//        if(divisor == 0)
//            return Integer.MAX_VALUE;
//
//        if(dividend < divisor)
//            return 0;
//        else
//            return 1 + divide(dividend - divisor, divisor);
//    }
}
