package ImportantQ.Bits.Concepts;
// Maximum Power of 2 possible for a number n, like for 20->4, 100->2^6
public class Max2Power {
    public static int max2Power(int n){
        int x = 0;
        while(1<<x <= n)
            x++;

        return --x;
    }
}
