package ImportantQ.Arrays;
import java.util.*;
//https://leetcode.com/problems/merge-intervals/
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array
// of the non-overlapping intervals that cover all the intervals in the input.
// Intervals may not be in Sorted form

public class MergeOverlappingIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // Sorting based on initial interval value

        List<int[]> arr = new ArrayList<>();
        if(intervals.length == 0){
            return arr.toArray(new int[0][]);
        }

        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] current : intervals){

            if(current[0] <= end){
                end = Math.max(end, current[1]);
            }
            else{
                arr.add(new int[]{start,end});
                start = current[0];
                end = current[1];
            }
        }
        arr.add(new int[]{start,end});
        return arr.toArray(new int[0][]);
    }
}
