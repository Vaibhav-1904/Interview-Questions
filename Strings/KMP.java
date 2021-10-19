package ImportantQ.Strings;
import java.util.*;
// drawback in naive pattern matching -> we are repeatedly checking characters in main string
// T->O(n*m)

public class KMP {
    public static int kmp(String str, String pattern){
        if(str.length() == 0 && pattern.length() == 0)
            return 0;

        if(pattern.length() == 0)
            return 0;
        int[] arr = new int[pattern.length()];
        calcSuffix(arr, arr.length, pattern);

        int i = 0, j = 0;
        while(i < str.length()){
            if(str.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else{
                if(j != 0)
                    j = arr[j - 1];
                else
                    i++;
            }

            if(j == pattern.length())
                return (i - pattern.length());
        }
        return -1;
    }

    static void calcSuffix(int[] arr, int n, String pattern){
        arr[0] = 0; // By definition

        for(int i = 1; i < n; i++){
            int j = arr[i - 1];

            while(j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = arr[j - 1];

            if(pattern.charAt(i) == pattern.charAt(j))
                j++;
            arr[i] = j;
        }
    }

    public static void main(String[] args) {
        String str = "GeeksForGeeks";
        String pattern = "Fo";

        System.out.println("Match at " + kmp(str, pattern) );
    }
}
