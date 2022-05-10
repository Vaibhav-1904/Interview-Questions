package ImportantQ.hashing2Pointer;
import java.util.*;
// Given an array nums of n integers, return an array of all the unique quadruplets
// [nums[a], nums[b], nums[c], nums[d]] such that:
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
public class FourSum {

//    // Brute-Force T->O(nlogn + n^3)
//    public static List<List<Integer>> fourSum(int[] arr, int target){
//        List<List<Integer>> ans = new ArrayList<>();
//        int n = arr.length;
//        Arrays.sort(arr);
//
//        for(int i = 0; i < n - 3; i++){
//            for(int j = i + 1; j < n - 2; j++){
//
//                int t = target - (arr[i] + arr[j]);
//                Map<Integer,Integer> m = new HashMap<>();
//
//                for(int k = j + 1; k < n; k++){
//                    if(m.containsKey(t - arr[k]) ){
//                        List<Integer> a = new ArrayList<>();
//                        a.add(arr[i]); // First element
//                        a.add(arr[j]); // Second
//                        a.add(arr[m.get(t - arr[k])]); // Third
//                        a.add(arr[k]); // Fourth
//                        if(!ans.contains(a)){
//                            ans.add(a);
//                        }
//                    }
//                    else {
//                        m.put(arr[k], k);
//                    }
//                }
//            }
//        }
//        return ans;
//    }

    //Optimal Approach T-> O(nlogn + n^2)
    public static List<List<Integer>> fourSum(int[] arr, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        if(arr.length == 0)
            return ans;

        Arrays.sort(arr);
        int n = arr.length;

        for(int i = 0; i < n - 3; i++){
            for(int j = i + 1; j < n - 2; j++) {
                int left = j + 1;
                int right = n - 1;
                int target2 = target - (arr[i] + arr[j]);
                while(left < right){

                    if(arr[left] + arr[right] < target2)
                        left++;
                    else if(arr[left] + arr[right] > target2)
                        right--;
                    else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(arr[i]); // First
                        quad.add(arr[j]); // Second
                        quad.add(arr[left]); // Third
                        quad.add(arr[right]); //Fourth

                        if(!ans.contains(quad))
                            ans.add(quad);

                        while(left < right && arr[left] == quad.get(2)) // To get rid of Duplicates in Array
                            left++;

                        while(left < right && arr[right] == quad.get(3)) // To get rid of Duplicates in Array
                            right--;
                    }
                }
                while(i < n - 1 && arr[i] == arr[i + 1]) // To get rid of Duplicates in Array
                    i++;

                while(j < n - 1 && arr[j] == arr[j + 1]) // To get rid of Duplicates in Array
                    j++;
            }
        }
        return ans;
    }

    public static void main(String[] args){

        int[] arr ={-3,-2,-1,0,0,1,2,3};
        int target = 0;

        System.out.println(fourSum(arr, 1));
    }
}
