package ImportantQ.Maths;

import java.util.Arrays;

public class SieveOfEratostenes {
    public static boolean[] sieve(int n){
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2;i * i <= n; i++ ){
            if(isPrime[i]){
                for(int j = 2 * i; j < n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
