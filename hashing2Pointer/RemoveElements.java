package ImportantQ.hashing2Pointer;
// https://leetcode.com/problems/remove-element/
public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        int head = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(nums[i] != val) {
                nums[head] = nums[i];
                head++;
            }
        }

        return head;
    }
}
