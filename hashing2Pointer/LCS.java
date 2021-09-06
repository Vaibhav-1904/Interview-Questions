package ImportantQ.hashing2Pointer;
//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
import java.util.*;
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9

//Longest Consecutive sequence
//Optimal Approach
public class LCS {
    //Optimal
    public int longestConsecutive(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
            return 1;

        int n = nums.length;
        int count = 1;
        int max = 1;
        HashSet<Integer> h = new HashSet<>();
        for(int i:nums)
            h.add(i);

        int i = 0;
        while(i < n){
            if(!h.contains(nums[i] - 1)){
                count = 1;
                while(h.contains(nums[i] + count))
                    count++;

                max = Math.max(max, count);
            }
            i++;
        }

        return max;

    }

    public static void main(String[] args){

        int[] nums ={100,4,4,200,1,3,2};

        // Brute Force
        Arrays.sort(nums);
        int n = nums.length;
        int c = 1;
        int max = 1;
        for(int i = 0; i < n-1; i++){
            if(nums[i+1] == nums[i])
                continue;
            else{
                if(nums[i+1] - nums[i] == 1){
                    c++;
                    if(c > max)
                        max = c;
                }
                else{
                    c = 1;
                }
            }
        }
    }
}
