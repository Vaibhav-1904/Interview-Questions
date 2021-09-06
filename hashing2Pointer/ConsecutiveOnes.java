package ImportantQ.hashing2Pointer;
// https://leetcode.com/problems/max-consecutive-ones/submissions/
public class ConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 0)
                count = 0;
            else {
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
