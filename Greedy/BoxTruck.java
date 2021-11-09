package ImportantQ.Greedy;
import java.util.*;
// https://leetcode.com/problems/maximum-units-on-a-truck/
public class BoxTruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);

        int temp = truckSize;
        int i = 0;
        int ans = 0;
        while(temp > 0 && i < boxTypes.length){
            if(temp > boxTypes[i][0]){
                temp = temp - boxTypes[i][0];
                ans += boxTypes[i][1] * boxTypes[i][0];
            }
            else{
                while(temp != 0) {
                    temp--;
                    ans += boxTypes[i][1];
                }
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] b = {{5, 10}, { 2,5}, {4, 7}, {3,9}};

        System.out.println(maximumUnits(b, 10));
    }
}
