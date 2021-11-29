package ImportantQ.hashing2Pointer;

import java.util.HashMap;
import java.util.Map;

//Given an Array arr and a number 'm', count the number of subArrays have XOR of their elements as 'm'
public class SubArrayXOR {
    public static void main(String[] args){

        int[] arr = {4, 2, 2, 6, 4};
        int m = 6;
        int n = arr.length;
        int xor = 0;
        int count = 0;

//        //Brute Force Approach
//        for(int i = 0; i < n; i++){
//
//            xor = 0;
//            for(int j = i; j < n; j++ ){
//                xor = xor ^ arr[j];
//
//                if(xor == m)
//                    count++;
//            }
//        }

        //Optimal Approach
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            xor = xor ^ arr[i];

            if(map.get(xor ^ m) != null)
                count += map.get(xor ^ m);

            if(xor == m)
                count++;

            if (map.get(xor) != null)
                map.put(xor, map.get(xor) + 1);
            else
                map.put(xor, 1);
        }

        System.out.println("Count : " + count);

    }
}
