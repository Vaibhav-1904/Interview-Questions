package ImportantQ.Arrays.TwoDArrays;

import java.util.Arrays;

// https://leetcode.com/problems/non-overlapping-intervals/
public class CountOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;

        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i-1][1] > intervals[i][0]){
                intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {1, 3}, {2, 3}};

        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);

        System.out.println(Arrays.deepToString(intervals));
    }
}
