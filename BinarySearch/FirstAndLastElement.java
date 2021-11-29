package ImportantQ.BinarySearch;
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastElement {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        if(n == 1){
            if(target == nums[0])
                return new int[]{0, 0};
            else
                return new int[]{-1, -1};
        }

        return BinarySearch(nums, target, 0, nums.length - 1);
    }

    int[] BinarySearch(int[] nums, int target, int l, int r){
        int[] result = new int[2];

        while(l <= r){
            int mid = (l + r) >> 1;

            if(nums[mid] > target)
                r = mid - 1;
            else if(nums[mid] < target)
                l = mid + 1;
            else{
                int i = mid;
                while(i > 0 && nums[mid] == nums[i])
                    i--;
                if(nums[i] != nums[mid])
                    i++;
                result[0] = i;
                i = mid;
                while(i < nums.length && nums[mid] == nums[i])
                    i++;
                if(i == nums.length || nums[i] != nums[mid])
                    i--;
                result[1] = i;

                return result;
            }
        }
        return new int[]{-1, -1};
    }
}
