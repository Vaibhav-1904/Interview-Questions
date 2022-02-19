package ImportantQ.Strings;
import java.util.*;
// https://leetcode.com/problems/partition-labels/
public class PartitionLabels {

//    // Naive
//    public List<Integer> partitionLabels(String s) {
//        int n = s.length();
//        List<Integer> result = new ArrayList<>();
//        HashMap<Character, Integer> map = new HashMap<>();
//        // It will give lastOccurrence of every character in s
//        for(int i = 0; i < n; i++){
//            if(map.containsKey(s.charAt(i)))
//                map.replace(s.charAt(i), i);
//            else
//                map.put(s.charAt(i), i);
//        }
//
//        int pre = -1, max = 0;
//        for(int i = 0; i < n; i++) {
//            if(max < map.get(s.charAt(i)))
//                max = map.get(s.charAt(i));
//
//            if(i == max){
//                result.add(max - pre);
//                pre = max;
//            }
//        }
//        return result;
//    }

    // Optimal
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();

        int firstIndex = 0;
        int lastIndex = s.lastIndexOf(s.charAt(0));


        while(firstIndex < n){

            if(s.lastIndexOf(s.charAt(firstIndex)) > lastIndex){
                lastIndex = s.lastIndexOf(s.charAt(firstIndex));
            }else if(firstIndex == lastIndex ) {
                result.add(1);
                firstIndex++;
                lastIndex++;
            }else{
                int start = firstIndex;

                while(start != lastIndex){
                    if(s.lastIndexOf(s.charAt(start)) > lastIndex)
                        lastIndex = s.lastIndexOf(s.charAt(start));
                    else
                        start++;
                }

                int toAdd = (lastIndex - firstIndex) + 1;
                result.add(toAdd);
                firstIndex = lastIndex + 1;
                lastIndex++;
            }
        }
        return result;
    }
}
