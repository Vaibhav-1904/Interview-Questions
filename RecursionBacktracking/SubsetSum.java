package ImportantQ.RecursionBacktracking;
import java.util.*;
// Given a list arr of N integers, print sums of all subsets in it. Output should be printed in increasing order of sums.
public class SubsetSum {

//    // Naive Approach T-> O(2^n * n), extra space n in T
//    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
//        ArrayList<Integer> sums = new ArrayList<>();
//
//        for(int num = 0; num < (1<<N); num++){
//            int sum = 0;
//            for(int i = 0; i < N; i++){
//                if((num & (1<<i)) > 0)
//                    sum += arr.get(i);
//            }
//            sums.add(sum);
//        }
//        Collections.sort(sums);
//        return sums;
//    }

    // Optimal T->2^n
    public static void subsetSums(ArrayList<Integer> arr, ArrayList<Integer> sums, int index, int sum){

        if(index == arr.size()){
            sums.add(sum);
            return;
        }
        // Do not add index value element to the Sum
        subsetSums(arr, sums, index + 1, sum);

        // Add Index value element to the sum
        subsetSums(arr, sums, index + 1, sum + arr.get(index));
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        ArrayList<Integer> sums = new ArrayList<>();
        subsetSums(arr, sums, 0, 0);
        Collections.sort(sums);

        for(int i: sums)
            System.out.print(i + " ");

    }
}
