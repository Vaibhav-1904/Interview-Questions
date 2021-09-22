package ImportantQ.Arrays;

//Given an array of size n, find the majority element. The majority element is the element that appears
// more than ⌊ n/2  times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.

public class MajorityElement {

    // Brute - O(n^2)
//    public static int majorityElement(int[] nums) {
//
//        int majority = 0;
//        int count = 0;
//        int index = -1;
//
//        for(int i = 0; i < nums.length; i++){
//            count = 0;
//            for(int  j = 0; j < nums.length; j++){
//                if(nums[i] == nums[j]){
//                    count++;
//                }
//            }
//            if(count > majority){
//                index = i;
//                majority = count;
//            }
//        }
//
//
//        if(majority > nums.length/2)
//            return nums[index];
//        else
//            return 0;
//    }
    
    public static void main(String[] args){
        
        int[] arr= {1,2,3,4,1,2,6,2,6,2,2,2,1};

        // Better Approach
//        Map<Integer,Integer> m = new HashMap<>();
//
//        for(int i : arr){
//            if(!m.containsKey(i)){
//                m.put(i,1);
//            }
//            else{
//                int update = m.get(i) + 1;
//                m.replace(i,m.get(i),update);
//            }
//        }
//
//        int max = m.get(arr[0]);
//        int index=0;
//        for(int i = 1; i < arr.length; i++){
//            if(m.get(arr[i]) > max)
//            {
//                max = m.get(arr[i]);
//                index = i;
//            }
//        }


        //Optimal Approach
        int majority = 0;
        int count = 0;

        for(int i:arr){
            if(count == 0)
                majority = i;

            if(i == majority)
                count++;
            else
                count--;
        }
    }

}
