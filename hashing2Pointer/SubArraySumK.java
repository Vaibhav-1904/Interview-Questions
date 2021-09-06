package ImportantQ.hashing2Pointer;
//Given an array of integers nums and an integer k,
// return the total number of continuous subarrays whose sum equals to k.

import java.util.HashMap;

public class SubArraySumK {

    //        //Brute Force
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int sum=0;
//            for (int j = i; j < arr.length; j++) {
//                sum += arr[j];
//                if (sum == k)
//                    count++;
//            }
//        }

    public static void main(String[] args){
        //Optimal
        int count = 0, sum = 0;
        int[] nums = {1,2,3};
        int k  = 3;

        // Mapping Sum and Counting number of times Sum occurs
        HashMap< Integer, Integer > map = new HashMap < > ();
        // Sum = 0 is there initially before start
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k))
                count += map.get(sum - k);

            // For Updating if sum already exists or not
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // return Count
    }
}
