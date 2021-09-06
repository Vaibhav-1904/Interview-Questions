package ImportantQ.Arrays;

//FInd if there exists a subarray with sum equals to zero.

import java.util.*;

public class SubArrayWithZeroSum {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        boolean found = false;
        int[] arr = {2, 4, -1, 2, -8, 6, -7, 0};
//        Set<Integer> s = new HashSet<>();
        int sum = 0;

//        int count = 0;
//        for(int element:arr){
//            s.add(sum);
//            sum += element;
//            if(s.contains(sum)){
//                found = true;
//                break;
//            }
//        }

        Map<Integer,Integer> m = new HashMap<>();
        int count = 0;
        int max = 0;

        for(int i = 0; i < arr.length; i++){
            m.putIfAbsent(sum,i);
            sum += arr[i];
            if(m.containsKey(sum)){
                count = i + 1 - m.get(sum);
                if(count > max){
                    max = count;
                }
                found = true;
            }
        }

        System.out.print("Found : " + found + "  " + max);

    }

}
