package ImportantQ.ArrayList;
import java.util.*;
//Given an integer array of size n, find all elements that appear more than ⌊ n/3  times
// https://leetcode.com/problems/majority-element-ii/
public class MajorityElement3 {
        // T -> O(n^2)
    //    public List<Integer> majorityElement(int[] nums) {
//        // Brute
//        int count = 0;
//        List<Integer> ans = new ArrayList<>();
//        for(int i = 0; i < nums.length; i++){
//            count = 0;
//            for(int j = 0; j < nums.length; j++){
//                if(nums[j] == nums[i])
//                    count++;
//            }
//            if(count > nums.length/3){
//                if(!ans.contains(nums[i])){
//                    ans.add(nums[i]);
//                }
//            }
//        }
//        return ans;
//    }


    // Optimal
    public List<Integer> majorityElement(int[] arr) {
        int num1 = -1;
        int num2 = -1;
        int count1 = 0, count2 = 0;

        for(int i:arr){

            if(i == num1)
                count1++;
            else if(i == num2)
                count2++;
            else if(count1 == 0){
                num1 = i;
                count1 = 1;
            }else if(count2 == 0){
                num2 = i;
                count2 = 1;
            }else
            {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i:arr){
            if(i == num1)
                count1++;
            else if(i == num2)
                count2++;
        }

        if(count1 > arr.length / 3)
            ans.add(num1);

        if(count2 > arr.length / 3)
            ans.add(num2);

        return ans;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,5,9,3,3,3,2,2,2};

//        // Better
//        Map<Integer,Integer> m = new HashMap<>();
//        int c = 0;
//        for(int i:nums){
//            if(!m.containsKey(i)){
//                m.put(i,1);
//                c++;
//            }
//            else{
//                int update = m.get(i) + 1;
//                m.replace(i,update);
//            }
//        }
//
//        List<Integer> ans = new ArrayList<>();
//        for(int i = 0; i < nums.length; i++){
//            if(m.get(nums[i]) > nums.length/3 && !ans.contains(nums[i]))
//                ans.add(nums[i]);
//        }

    }
}
