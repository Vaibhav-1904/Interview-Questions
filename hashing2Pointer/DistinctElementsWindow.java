package ImportantQ.hashing2Pointer;
import java.util.*;
// Input: arr[] = {1, 2, 1, 3, 4, 2, 3};
//       k = 4
//Output: 3 4 4 3

// https://www.youtube.com/watch?v=j48e8ac7r20&list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p&index=29
public class DistinctElementsWindow {
//    // Naive Approach T->O(n*k^2)
//    public static ArrayList<Integer> countDistinct(int[] arr, int n, int k)
//    {
//        ArrayList<Integer> result = new ArrayList<>();
//        for(int i = 0; i < n - k + 1; i++){
//            int count = 0;
//            for(int j = i; j < i + k; j++){
//                boolean flag = true;
//                for(int s = i; s < j; s++){
//                    if(arr[j] == arr[s]) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if(flag) count++;
//            }
//            result.add(count);
//        }
//        return result;
//    }

    // Optimal Solution
    static ArrayList<Integer> countDistinct(int[] arr, int n, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < k; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        result.add(map.size());
        for(int i = k; i < arr.length; i++){

            if(map.get(arr[i - k]) == 1)
                map.remove(arr[i - k]);
            else
                map.put(arr[i - k], map.get(arr[i - k]) - 1);

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            result.add(map.size());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4,2,3};
        ArrayList<Integer> result = countDistinct(arr, 7, 4);

        for(int i:result)
            System.out.println(i);
    }
}
