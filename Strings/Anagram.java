package ImportantQ.Strings;

import java.util.Scanner;

public class Anagram {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        String a = "cat321*@a";
        String b = "act123@*a";

        if(a.length() != b.length()){
            System.out.println("Strings are NOT Anagram .. ");
            return;
        }

        boolean isAnagram = true;

//        //Naive Approach
//        boolean[] visited = new boolean[a.length()];
//
//        for(int i = 0; i < a.length();i++)
//        {
//            char c = a.charAt(i);
//            isAnagram = false;
//            for (int j = 0; j < a.length(); j++)
//            {
//                if(b.charAt(j) == c && !visited[j])
//                {
//                    visited[j] = true;
//                    isAnagram = true;
//                }
//            }
//            if(!isAnagram)
//                break;
//        }

        //Optimal Way
        int[] ar = new int[256];

        for(char c:a.toCharArray())
        {
            ar[(int)c]++;
        }

        for(char c:b.toCharArray())
        {
            ar[(int)c]--;
        }
        for(int i = 0; i < 256; i++)
        {
            if(ar[i] != 0)
            {
                isAnagram = false;
                break;
            }
        }

        if(isAnagram)
        {
            System.out.print("Strings are Anagram ... ");
        }
        else
            System.out.print("Strings are NOT Anagram .. ");

    }
}
