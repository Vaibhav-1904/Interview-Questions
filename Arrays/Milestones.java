package ImportantQ.Arrays;
// https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/
public class Milestones {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0, max = 0;
        for(int i : milestones) {
            sum += i;
            max = Math.max(max, i);
        }

        long x = sum - max;

        if(max > x)
            return sum - (max - x - 1);

        return sum;
    }
}
