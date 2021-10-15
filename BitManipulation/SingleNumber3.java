package ImportantQ.BitManipulation;
import java.util.List;
// Given an array of integers, every element appears thrice except for one which occurs once.
// Find that element which does not appear thrice.
// This is q question where k = 3, k can be any number
// https://www.geeksforgeeks.org/find-unique-element-element-occurs-k-times-except-one/
public class SingleNumber3 {
    // Naive Solution -> Use 2 for loops and in second for find whether Ith element is repeating or not.

    // Optimal T->O(n)
    public int singleNumber(final List<Integer> arr) {
        int[] count = new int[32];

        for(int i = 0; i < 32; i++){
            for (int j : arr) {
                if ((j & (1 << i)) != 0) {
                    count[i]++;
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
