package ImportantQ.hashing2Pointer;
import java.util.*;
// https://leetcode.com/problems/intersection-of-two-arrays-ii/

public class IntersectionArrays {
//    // T->O(nlogn)
//    public int[] intersect(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int i = 0;
//        int j = 0;
//        ArrayList<Integer> arr = new ArrayList<>();
//        while( i < nums1.length && j < nums2.length){
//            if(nums1[i] == nums2[j]){
//                arr.add(nums1[i]);
//                i++;
//                j++;
//            }else if(nums1[i] < nums2[j])
//                i++;
//            else
//                j++;
//        }
//        int[] result = new int[arr.size()];
//        for(i = 0; i < arr.size(); i++)
//            result[i] = arr.get(i);
//
//        return result;
//    }

    // Optimal -> instead of amp we can also use a frequency array and increment all nums1 element and check while querying nums2 if freq[nums2[i]] > 0
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums1){
            if(map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i : nums2){
            if(map.containsKey(i)){
                if(map.get(i) > 0){
                    arr.add(i);
                    map.put(i, map.get(i) - 1);
                }
            }
        }

        int[] result = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++)
            result[i] = arr.get(i);

        return result;
    }
}
