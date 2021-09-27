package ImportantQ.Greedy;
import java.util.*;
// https://www.youtube.com/watch?v=LjPx4wQaRIs
public class JobSequencing {
    static class Job{
        int id;
        int deadline;
        int profit;
    }

    //Function to find the maximum profit and the number of jobs done.
    public static int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (j1, j2) -> j2.profit - j1.profit);

        int maxDeadline = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i].deadline > maxDeadline)
                maxDeadline = arr[i].deadline;
        }

        boolean[] jobDone = new boolean[maxDeadline + 1];
        int count = 0, profit = 0;

        for(int i = 0; i < n; i++){
            for(int j = arr[i].deadline; j > 0; j--){
                if(!jobDone[j]){
                    jobDone[j] = true;
                    count++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }
        return new int[]{count, profit};
    }
}
