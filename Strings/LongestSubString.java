package ImportantQ.Strings;

import java.util.HashSet;
// Given a string s, find the length of the longest substring without repeating characters.

public class LongestSubString {
//    //Naive T->O(n^2)
//    public int lengthOfLongestSubstring(String s) {
//        int count = 0, max = 0;
//        for(int i = 0; i < s.length(); i++){
//            HashSet<Character> h = new HashSet<>();
//            count = 0;
//            for(int j = i; j < s.length(); j++){
//                if(h.contains(s.charAt(j))){
//                    break;
//                }else{
//                    h.add(s.charAt(j));
//                    count++;
//                }
//            }
//            if(count > max)
//                max = count;
//        }
//        return max;
//    }

    // Optimal T->O(n)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        for(right = 0; right < n; right++){
            if(set.contains(s.charAt(right))){
               while(set.contains(s.charAt(right))){
                   set.remove(s.charAt(left));
                   left++;
               }
               set.add(s.charAt(right));
            }else{
                set.add(s.charAt(right));
            }
            max = Math.max(max, (right - left) + 1);
        }
        return max;
    }
}
