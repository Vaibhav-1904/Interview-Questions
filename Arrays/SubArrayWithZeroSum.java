package ImportantQ.Arrays;

//FInd if there exists a subarray with sum equals to zero.

import java.util.*;

public class SubArrayWithZeroSum {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        boolean found = false;
        int[] arr = {3, 4, -1, 2, -8, 6, -7, 0};
        int sum = 0;

        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;

        for(int i = 0; i < arr.length; i++) {
            map.putIfAbsent(sum, i);
            sum += arr[i];
            if(map.containsKey(sum)) {
                count = i + 1 - map.get(sum);
                max = Math.max(max, count);
                found = true;
            }
        }

        System.out.print("Found : " + found + "  " + max);

    }

}
