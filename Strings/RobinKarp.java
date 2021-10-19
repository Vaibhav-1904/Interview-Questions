package ImportantQ.Strings;
import  java.lang.Math;

public class RobinKarp {

    // T-> O(m * (n - m))
    public static int rabinKarp(String str, String pattern){
        int n = str.length();
        int m = pattern.length();
        double pattern_code = Cal_Hash(pattern);

        for(int i = 0; i <= (n - m); i++)
        {
            if( Cal_Hash(str.substring(i, m + i)) == pattern_code )
                return i;
        }
        return -1;
    }

    static double Cal_Hash(String a){

        double sum = 0;
        for(int i = 1; i <= a.length(); i++)
        {
            char ch = a.charAt(i - 1);
            sum += (int)ch * (Math.pow(10, a.length() - i)); // 10^(n - i)
        }
        return sum;
    }


    public static void main(String[] args)
    {
        String str = "GeeksForGeeks";
        String pattern = "Fo";

        System.out.println("Match at " + rabinKarp(str, pattern) );
    }
}
