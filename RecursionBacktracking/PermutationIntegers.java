package ImportantQ.RecursionBacktracking;
import java.util.*;
// Given an array nums of distinct integers, return all the possible permutations.
// You can return the answer in any order.

public class PermutationIntegers {

    public static ArrayList<Integer> swap(ArrayList<Integer> arr, int i, int j){

        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);

        return arr;
    }

    static void printPermutations(List<List<Integer>> ans, ArrayList<Integer> nums, int index){
        if(index == nums.size() - 1){
            ans.add(nums);
        }

        for(int i = index; i < nums.size(); i++){
            nums = swap(new ArrayList<>(nums), index, i);
            printPermutations(ans, nums, index + 1);

            //Backtrack
            nums = swap(new ArrayList<>(nums), index, i);
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        printPermutations(ans, nums, 0);


//        Collections.sort(p, (o1, o2) -> {
//            for(int i = 0; i < o1.size(); i++) {
//                if (o1.get(i) == o2.get(i))
//                    continue;
//                else
//                    return o1.get(i) - o2.get(i);
//            }
//            return 1;
//        });
        for(List<Integer> i:ans)
            System.out.println(i);
    }
}
