package ImportantQ.BinarySearch;

public class sqrt {

    public int mySqrt(int x) {
        if(x < 2)
            return x;

        long low = 1;
        long high = x/2;  // Floor value of Sqrt(x) cannot be greater than x/2;
        long ans = 0;

        while(low <= high){
            long mid = (low+high)/2;
            if(mid*mid == x)
                return (int)mid;

            if((mid*mid) < x){
                low = mid + 1;
                ans = mid; // Since we need to use Floor Value, we update ans when mid*mid<x, and we move closer to Sqrt(x)
            }
            else
                high = mid - 1;
        }
        return (int)ans;
    }

}
