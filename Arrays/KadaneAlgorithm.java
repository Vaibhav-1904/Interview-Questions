package ImportantQ.Arrays;

import java.util.Scanner;

// Given an integer array arr, find the contiguous subarray (containing at least one number)
// which has the largest sum and return its sum.

public class KadaneAlgorithm {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

       int[] arr= {-2,1,-3,4,-1,2,1,-5,4};
       int n = arr.length;


        //Brute-Force
//        int sum = 0;
//        int max = arr[0];
//        for(int i = 0; i < n; i++){
//            for(int j = i; j < n; j++){
//
//                sum = 0;
//                for(int k = i; k <= j; k++){
//                    sum += arr[k];
//                }
//                if(sum > max){
//                    max = sum;
//                }
//            }
//        }

        //Optimised Form
//        int sum = 0;
//        int max = arr[0];
//        for(int i = 0; i < n; i++){
//            sum = 0;
//            for(int j = i; j < n; j++){
//                sum += arr[j];
//                if(sum > max){
//                    max = sum;
//                }
//            }
//        }

        //Optimal
        int max_so_far = arr[0];
        int max_ending_here = 0;

        for (int i : arr) {
            max_ending_here += i;

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }

            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }

        //The simple idea of Kadane’s algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this).
        // And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this).
        // Each time we get a positive-sum compare it with max_so_far and update max_so_far if it is greater than max_so_far

        System.out.println("Largest Sum of a SubArray in Array is : " + max_so_far);


    }

}
