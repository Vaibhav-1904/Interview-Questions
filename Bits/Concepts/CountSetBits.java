package ImportantQ.Bits.Concepts;

public class CountSetBits {
//    // Naive
//    public static int countSetBits(int x){
//        int count = 0;
//        while(x > 0){
//            if((x & 1) == 1)
//                count++;
//            x = x>>1;
//        }
//        return count;
//    }

    // Optimal
    public static int countSetBits(int x){
        int count = 0;
        while(x > 0){
            count++;
            x = x & (x - 1);
        }
        return count;
    }
}
