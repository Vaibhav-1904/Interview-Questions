package ImportantQ.ArrayList;
import java.util.*;
//Given an integer array of size n, find all elements that appear more than ⌊ n/3  times

public class MajorityElement3 {
    // Optimal
    public List<Integer> majorityElement(int[] arr) {
        int num1 = -1;
        int num2 = -1;
        int c1 = 0, c2 = 0;

        for(int i:arr){

            if(i == num1)
                c1++;
            else if(i == num2)
                c2++;
            else if(c1 == 0){
                num1 = i;
                c1 = 1;
            }else if(c2 == 0){
                num2 = i;
                c2 = 1;
            }else
            {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i:arr){
            if(i == num1)
                c1++;
            else if(i == num2)
                c2++;
        }

        if(c1 > arr.length / 3)
            ans.add(num1);

        if(c2 > arr.length / 3)
            ans.add(num2);

        return ans;
    }

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
