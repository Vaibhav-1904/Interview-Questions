package ImportantQ.BinarySearch;
// https://leetcode.com/problems/powx-n/
public class PowerFunction {

    //Recursive Approach
    static int PowerAns(int a, int b) {
        if(b == 0)
            return 1;
        else if(b == 1)
            return a;
        else if(b % 2 == 0)
            return PowerAns(a * a,b / 2);
        else {
            return a * PowerAns(a*a,b / 2);
        }
    }

    //Iterative Approach
    static double power(double a, int b) {
        double ans = 1.0;
        long m = b;
        if(m < 0) // if power is -ve
            m = -1 * m;

        while(m > 0){
            if(m % 2 == 1){
                ans = ans * a;
                m--;
            }
            else{
                a = a * a;
                m = m / 2;
            }
        }
        if(b < 0) // if power is -ve
            ans = (1.0) / (ans);

        return ans;
    }

    public static void main(String[] args){

        int x = PowerAns(2,10);
        System.out.println(x);

    }
}
