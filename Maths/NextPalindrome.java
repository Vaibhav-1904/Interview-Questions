package ImportantQ.Maths;

public class NextPalindrome {
    public int PrimePalindrome(int N)
    {
        int p = N;
        while(p>=N){
            if(isPalindrome(p) == 1){
                if(isPrime(p) == 1){
                    return p;
                }
            }
            p++;
        }
        return p;
    }

    static int isPalindrome(int p) {
        int rev = 0, r, temp;
        temp = p;
        while(p != 0)
        {
            r = p % 10;
            rev = rev * 10 + r;
            p = p/10;
        }
        if(temp==rev){
            return 1;
        }
        return 0;
    }
    static int isPrime(int n){
        if(n==1 || n==2)
            return n-1;
        for(int i = 2; i * i <= n; i ++)
        {
            if(n % i == 0)
            {
                return 0;
            }
        }
        return 1;
    }
}
