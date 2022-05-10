package ImportantQ.Arrays.ArrayList;
import java.util.*;
// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//You may assume that the intervals were initially sorted according to their start times.

public class MergeIntervals {
    public static  class Interval{
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        if(intervals == null){
            intervals = new ArrayList<>();
            intervals.add(newInterval);
            return intervals;
        }
        else if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }

        int i = 0;
        while(i < intervals.size()){
            Interval current = intervals.get(i);

            if(current.end < newInterval.start){
                i++;
            }
            else if(current.start > newInterval.end){
                intervals.add(i, newInterval);
                break;
            }
            else {
                newInterval.start = Math.min(newInterval.start, current.start);
                newInterval.end = Math.max(current.end, newInterval.end);
                intervals.remove(i);
            }
        }

        if(i == intervals.size()){
            intervals.add(newInterval);
        }

        return intervals;
    }

    public static void main(String[] args){

        ArrayList<Interval> arr = new ArrayList<>();

        for(int i = 2; i < 10; i = i*2){
            int j = i+1;
            Interval a = new Interval(i,j);
            arr.add(a);
        }

        Interval n = new Interval(3,7);

        ArrayList<Interval> ans = new ArrayList<>();
        ans = insert(arr, n);

        for(Interval i:ans){
            System.out.println(i.start + " " + i.end);
        }
    }
}
