package ImportantQ.Strings;
import java.util.Scanner;
// Return a string of the words in reverse order concatenated by a single space between each word.
public class StringReverse {

    public static String rev(String s){

        String ans = "";
        s = s.trim();
        int i = s.length() - 1;
        while(i >= 0)
        {
            while(i >= 0 && s.charAt(i) == ' ')
                i--;

            int j = i;
            while(i >= 0 && s.charAt(i) != ' ')
                i--;

            ans = ans.concat(s.substring(i+1,j+1));
            ans = ans.concat(" ");
        }
        ans = ans.trim();
        return ans;
    }

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();

        System.out.print(rev(s));

//        String[] arr = s.split(" ");
//
//        for(int i = arr.length - 1; i >= 0; i--)
//        {
//            if(!arr[i].equals(" "))
//            {
//                System.out.print(arr[i].trim() + " ");
//            }
//
//        }


    }
}
