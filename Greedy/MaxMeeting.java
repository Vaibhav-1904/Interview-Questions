package ImportantQ.Greedy;
import java.util.*;
// There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
//What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?
public class MaxMeeting {
    static class meeting{
        int id;
        int start, end;
        meeting(int id, int start, int end)
        {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }

    public static int maxMeetings(int[] start, int[] end, int n)
    {
        // add your code here
        ArrayList<meeting> meet = new ArrayList<>();
        for(int i = 0; i < start.length; i++)
            meet.add(new meeting(1, start[i], end[i]));

        meet.sort((m1, m2)->m1.end - m2.end);

        int count = 1;
        int limit = meet.get(0).end;
        for(int i = 1; i < start.length; i++){
            if(meet.get(i).start > limit){
                limit = meet.get(i).end;
                count++;
            }
        }
        return count;
    }
}
