package ImportantQ.RecursionBacktracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// Print all permutations of a given String.
public class Permutations {
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    static void printPermutations(String str, int index){
        if(index == str.length() - 1){
            System.out.println(str);
        }

        for(int i = index; i < str.length(); i++){
            str = swap(str, index, i);
            printPermutations(str, index + 1);

            //Backtrack
            str = swap(str, index, i);
        }
    }
    public static void main(String[] args) {
        printPermutations("abc", 0);
    }
}
