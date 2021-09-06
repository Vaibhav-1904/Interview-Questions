package ImportantQ.Bits;
import java.util.List;
// Given an array of integers, every element appears thrice except for one which occurs once.
// Find that element which does not appear thrice.
// This is q question where k is 3, k can be any number
public class SingleNumber3 {
    // Naive Solution -> Use 2 for loops and in second for find whether Ith element is repeating or not.

    // Optimal
    public int singleNumber(final List<Integer> arr) {
        int[] count = new int[32];

        for(int i = 0; i < 32; i++){
            for (Integer j : arr) {
                if ((j & (1 << i)) != 0) {
                    count[i] += 1;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < 32; i++){
            if(count[i] % 3 != 0){
                ans = ans + (1 << i);
            }
        }
        return ans;
    }
}
