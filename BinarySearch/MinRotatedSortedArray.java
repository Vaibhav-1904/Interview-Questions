package ImportantQ.BinarySearch;
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if(r == 0)
            return nums[0];

        while(l <= r) {
            int mid = (l + r) >> 1;

            if(nums[l] <= nums[mid]) {
                if(nums[l] <= nums[r]){
                    return nums[l];
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[mid] < nums[r]){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
        }

        return nums[l];
    }
}
