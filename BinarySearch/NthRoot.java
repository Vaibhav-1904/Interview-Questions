package ImportantQ.BinarySearch;
import java.util.*;
// You  are given two numbers M and N, you need to find (M)^(1/N), Nth root of M.
//

public class NthRoot {

    public static double multiply(double m, int n)
    {
        double ans = 1;
        for(int i = 0; i < n; i++){
            ans *= m;
        }
        return ans;
    }

    public static double getNthRoot(int m, int n){

        double low = 1;
        double high = m;
        double eps = 1e-6; // It means 10 to the power -6, whatever number of decimal places you want the ans to be
        while((high-low) > eps){
            double mid = (high+low)/2;

            if(multiply(mid,n) > m)
                high = mid;
            else
                low = mid;
        }
        return high;
    }

    public static void main(String[] args) {
        double d = getNthRoot(27,3);

        System.out.println(d);
    }
}
