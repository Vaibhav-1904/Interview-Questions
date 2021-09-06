package ImportantQ.Bits;

import java.util.ArrayList;

// Reverse the bits of an 32 bit unsigned integer A.
public class ReverseBits {
//    // Naive -> We store each set or unset bit in arraylist and then traverse anc calculate the answer
//    public long reverse(long a) {
//        long b = 0;
//        ArrayList<Long> arr = new ArrayList<>();
//        for(int i = 1; i <= 32; i++){
//            arr.add(a&1);
//            a = a>>1;
//        }
//        long ans = 0;
//        for(int i = 0; i < 32; i++){
//            ans = ans + (long)Math.pow(2,31 - i) * arr.get(i);
//        }
//        return ans;
//    }

    //Optimal
    public long reverse(long a) {
        long b = 0;
        for(int i = 0; i < 32; i++){
            b = b << 1;
            b = b | (a&1);
            a = a >> 1;
        }
        return b;
    }
}
