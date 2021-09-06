package ImportantQ.hashing2Pointer;

import java.util.*;

public class LargestSubArrayZeroSum {
    public static void main(String[] args){
        int[] arr = {15, -2, 2,-8, 1,7,-23,2};
        int n = arr.length;
        //Brute Force Approach
//        int sum = 0;
//        int length = 0, max = 0;
//
//        for(int i = 0; i < n; i++){
//            sum = 0;
//            for(int j = i; j < n; j++){
//                sum += arr[j];
//                length = j - i + 1;
//                if(sum == 0){
//                    if(length > max)
//                        max = length;
//                }
//            }
//        }


        Map<Integer,Integer> m = new HashMap<>();

        int sum = 0;
        int max = 0, count = 0;

        for (int i = 0; i < n; i++){
            sum += arr[i];

            if(m.containsKey(sum)){
                count = i - m.get(sum);
                max = Math.max(max, count);
            }
            else {
                m.put(sum,i);
            }
        }

        System.out.println("Max SubArray is of Length : " + max);

    }
}
