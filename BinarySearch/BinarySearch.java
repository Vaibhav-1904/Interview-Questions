package ImportantQ.BinarySearch;

public class BinarySearch {

    int binarySearch(int[] nums, int l, int r, int target) {

        int mid = (l + r) >> 1;

        if(nums[mid] == target)
            return mid;
        else if(nums[mid] > target && mid > 0)
            return binarySearch(nums, l, mid - 1, target);
        else if(nums[mid] < target && mid < r)
            return binarySearch(nums, mid + 1, r, target);
        else
            return -1;
    }
}
