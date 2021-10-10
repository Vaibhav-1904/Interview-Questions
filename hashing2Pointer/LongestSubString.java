package ImportantQ.hashing2Pointer;
import java.util.*;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
//Given a string s, find the length of the longest substring without repeating characters.
public class LongestSubString {

    public static void main(String[] args){

        String s = "abcabcdbb";
        int n = s.length();
        int max = 0;
        int count = 0;

//        //Naive Approach
//        for(int i = 0; i < n; i++){
//            count = 0;
//            HashSet<Character> set = new HashSet<>();
//            for(int j = i; j < n; j++)
//            {
//                if(set.contains(s.charAt(j))){
//                    count = 1;
//                }
//                else{
//                    count++;
//                    set.add(s.charAt(j));
//                }
//
//                if(count > max)
//                    max = count;
//            }
//        }

        //Optimal Approach
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right;

        for(right = 0; right < n; right++){
            if(set.contains(s.charAt(right))){
                while (set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            count = right - left + 1;
            if(count > max)
                max = count;
        }

        System.out.println("Max is " + max);

    }

}
