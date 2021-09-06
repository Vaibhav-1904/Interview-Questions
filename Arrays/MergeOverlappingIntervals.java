package ImportantQ.Arrays;
import java.util.*;
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array
// of the non-overlapping intervals that cover all the intervals in the input.
// Intervals may not be in Sorted form

public class MergeOverlappingIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
//        Arrays.sort(intervals,new Comparator<Interval>(){
//            public int compare(Interval i1,Interval i2)
//            {
//                return i1.start-i2.start;
//            }
//        });

        List<int[]> arr = new ArrayList<>();

        if(intervals.length == 0 || intervals == null){
            return arr.toArray(new int[0][]);
        }

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i:intervals){
            if(i[0] <= end){
                end = Math.max(end,i[1]);
            }
            else{
                arr.add(new int[]{start,end});
                start = i[0];
                end = i[1];
            }
        }

        arr.add(new int[]{start,end});

        return arr.toArray(new int[0][]);

    }

}
