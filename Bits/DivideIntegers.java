package ImportantQ.Bits;

public class DivideIntegers {
    public int divide(int A, int B) {
        int sign = (A < 0 ^ B < 0) ? -1 : 1; // if both are -ve or both are +ve the 1
        long m = Math.abs((long)A);
        long n = Math.abs((long)B);
        long t = 0;
        long q = 0;
        for(long i=31;i>=0;i--) {
            if(( t + (n << i) ) <= m) {
                t += (n << i );
                q = q | (1L << i);
            }
        }
        if(sign<0)
            q =- q;
        if(q>=Integer.MAX_VALUE || q<Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        return (int)q;
    }

//    public int divide(int dividend, int divisor) {
//        if(divisor == 0)
//            return Integer.MAX_VALUE;
//
//        long ans = ((long)dividend)/divisor,num = Integer.MAX_VALUE;
//        if(ans>num)
//            return (int)num;
//
//        return (int)ans;
//    }
}
