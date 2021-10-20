package ImportantQ.RecursionBacktracking;
// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.
import java.util.*;

public class KthPermutationSequence {

    // Naive Approach
    // public void printPermutations(List<List<Integer>> ans, ArrayList<Integer> nums, int index){
    //     if(index == nums.size() - 1){
    //         ans.add(nums);
    //     }

    //     for(int i = index; i < nums.size(); i++){
    //         nums = swap(new ArrayList<>(nums), index, i);
    //         printPermutations(ans, nums, index + 1);

    //         //Backtrack
    //         nums = swap(new ArrayList<>(nums), index, i);
    //     }
    // }

    // public ArrayList<Integer> swap(ArrayList<Integer> arr, int i, int j){

    //     int temp = arr.get(i);
    //     arr.set(i, arr.get(j));
    //     arr.set(j, temp);

    //     return arr;
    // }

    // public String getPermutation(int n, int k) {

    //     if(n == 1){
    //         return "1";
    //     }

    //     List<List<Integer>> ans = new ArrayList<>();
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     for(int i = 1; i <= n; i++){
    //         arr.add(i);
    //     }

    //     printPermutations(ans, arr, 0);
    //     Collections.sort(ans, (o1, o2) -> {
    //         for(int i = 0; i < o1.size(); i++) {
    //             if (o1.get(i) == o2.get(i))
    //                 continue;
    //             else
    //                 return o1.get(i) - o2.get(i);
    //         }
    //         return 1;
    //     });

    //     String result = String.valueOf(ans.get(k - 1));
    //     return result;
    // }

    // Optimal T -> O(n^2), S -> O(N)
    public String getPermutation(int n, int k) {
        int factorial = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i  = 1; i < n; i++){
            numbers.add(i);
            factorial *= i; // (n - 1)! is calculated
        }
        numbers.add(n);
        String result = "";
        k--;

        while(true){
            result += numbers.get(k / factorial);
            numbers.remove(k / factorial);
            if(numbers.size() == 0)
                break;
            k = k % factorial;
            factorial /= numbers.size();
        }
        return result;
    }
}
