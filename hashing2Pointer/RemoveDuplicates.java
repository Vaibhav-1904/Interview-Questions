package ImportantQ.hashing2Pointer;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates {
//    // Naive T->O(n^2)
//    public int removeDuplicates(int[] nums) {
//
//        HashSet<Integer> set = new HashSet<>();
//        int n = nums.length;
//        int i = 0;
//
//        while(true) {
//            if(nums[i] == nums[n - 1])
//                break;
//
//            if(set.contains(nums[i])) {
//                for(int j = i; j < n - 1; j++)
//                    nums[j] = nums[j + 1];
//            }else{
//                set.add(nums[i++]);
//            }
//        }
//
//        return set.size() + 1;
//    }

    // Optimal T->O(n)
    public int removeDuplicates(int[] nums) {

        int head = 0;
        int j = 1;
        int n = nums.length;

        while(j < n) {
            if(nums[j] == nums[head]) {
                j++;
            }else {
                nums[++head] = nums[j++];
            }
        }

        return head + 1;
    }
}
