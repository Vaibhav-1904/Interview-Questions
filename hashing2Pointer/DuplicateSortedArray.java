package ImportantQ.hashing2Pointer;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
import java.util.HashSet;
public class DuplicateSortedArray {

//    //Naive Approach
//    public int removeDuplicates(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        int i = 0;
//        while(i < nums.length){
//            if(nums[i] == nums[nums.length - 1])
//                break;
//
//            if(set.contains(nums[i])){
//                for(int j = i; j < nums.length - 1; j++){
//                    nums[j] = nums[j + 1];
//                }
//            }else{
//                set.add(nums[i]);
//                i++;
//            }
//        }
//        return set.size() + 1;
//    }

//    //Naive
//    public int removeDuplicates(int[] nums) {
//
//        HashSet<Integer> set = new HashSet<>();
//        for(int i:nums){
//            set.add(i);
//        }
//        int i = 0;
//        for(int n:set){
//            nums[i] = n;
//            i++;
//        }
//        return set.size();
//    }

    // T -> O(n)
    public int removeDuplicates(int[] nums){
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else{
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
