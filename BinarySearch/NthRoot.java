package ImportantQ.BinarySearch;
import java.util.*;
// You  are given two numbers M and N, you need to find (M)^(1/N), Nth root of M.
//

public class NthRoot {

    public static double multiply(double mid, int power)
    {
        double ans = 1;
        for(int i = 0; i < power; i++) {
            ans *= mid;
        }
        return ans;
    }

    public static double getNthRoot(int num, int power){ // (m)^(1/n)
        // answer will lie between 1 -> m, because if n is infinity, ans will be m^0 = 1
        // and if n == 1, then ans = m,   as m^1 = m
        double low = 1;
        double high = num;
        double eps = 1e-6; // It means 10 to the power -6, whatever number of decimal places you want the ans to be
        while((high - low) > eps){
            double mid = (high + low) / 2;

            if(Math.pow(mid, power) > num)
                high = mid;
            else
                low = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        double d = getNthRoot(40,4);

        System.out.println(d);
    }
}
