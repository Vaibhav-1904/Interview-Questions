package ImportantQ.RecursionBacktracking;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
// Given an array of n positive integers, print All the subsets of given set.
public class Subsets {

    //    T-> O(n * 2^n), S -> O(n) -> Naive
    public static void findSubsets(List<List<Integer>> subset, ArrayList<Integer> nums, ArrayList<Integer> output, int index){
        if(index == nums.size())
        {
            subset.add(output);
//            for(int i: output){
//                System.out.print(i + " ");
//            }
//            System.out.println();
            return;
        }
        // Not Including index Value
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);

        // Including index Value
        output.add(nums.get(index));
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }

    //Optimal -> Bit Manipulation
//    public static void findSubsets(List<List<Integer>> subset, ArrayList<Integer> nums){
//        int n = nums.size();
//
//        for(int i = 1; i < (1<<n); i++){ // 0 -> 2^n - 1
//            ArrayList<Integer> arr = new ArrayList<>();
//            for(int j = 0; j < n; j++){
//                if((i & (1<<j)) > 0){
//                    arr.add(nums.get(j));
//                }
//            }
//            subset.add(arr);
//        }
//    }

    public static void main(String[] args) {
        List<List<Integer>> subset = new ArrayList<>();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);input.add(2);input.add(3);
        findSubsets(subset, input, new ArrayList<>(), 0);

        subset.sort((o1, o2) -> {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++) {
                if (o1.get(i) == o2.get(i)) {
                    continue;
                } else {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 1;
        });

        for(List<Integer> i:subset){
            System.out.println(i);
        }
//        for(int i = 0; i < subset.size(); i++){
//            for(int j = 0; j < subset.get(i).size(); j++){
//                System.out.print(subset.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
    }
}
