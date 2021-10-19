package ImportantQ.Strings;

import java.util.Scanner;

public class Anagram {
//    //        //Naive Approach T->O(n^2)
//    static boolean isAnagram(String a, String b) {
//        if(a.length() != b.length())
//            return false;
//
//        boolean[] visited = new boolean[a.length()];
//        for(int i = 0; i < a.length(); i++)
//        {
//            char c = a.charAt(i);
//            boolean flag = false;
//            for (int j = 0; j < a.length(); j++)
//            {
//                if(b.charAt(j) == c && !visited[j])
//                {
//                    visited[j] = true;
//                    flag = true;
//                }
//            }
//            if(!flag)
//                return false;
//        }
//        return true;
//    }

    // T->O(n)
    static boolean isAnagram(String a, String b){
        if(a.length() != b.length())
            return false;

        int[] arr = new int[256];

        for(char c : a.toCharArray())
            arr[c]++;

        for(char c : b.toCharArray())
            arr[c]--;

        for(int i : arr){
            if(i != 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {

        String a = "cat321*@a";
        String b = "act123@*a";
        System.out.println(isAnagram(a, b));
    }
}
