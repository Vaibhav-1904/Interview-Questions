package ImportantQ.Strings;

import java.util.*;

public class MinWindowSubString {
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        int[] ch = new int[256];
        int min = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;

        for(char c : p.toCharArray()) {
            if(ch[c] == 0)
                count++;
            ch[c]++;
        }

        int i = 0, j = 0;

        while(j < s.length()) {
            char c = s.charAt(j);
            ch[c]--;
            if(ch[c] == 0)
                count--;

            if(count == 0){
                while(count == 0){
                    if(min > (j - i + 1)){
                        min = j-i+1;
                        start = i;
                    }
                    int index = s.charAt(i);
                    ch[index]++;
                    if(ch[index] > 0)
                        count++;

                    i++;
                }
            }
            j++;
        }
        if(min == Integer.MAX_VALUE)
            return "-1";
        return s.substring(start, start + min);
    }

    public static void main(String[] args) {
        System.out.println(smallestWindow("thisisateststring", "tist")); //tstri
    }
}
