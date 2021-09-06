package ImportantQ.RecursionBacktracking;
// String is palindrome or not
public class Palindrome {
    static boolean checkPalindrome(String str, int i, int j){
        if(i > j)
            return true;
        else if(str.charAt(i) != str.charAt(j))
            return false;
        else
            return checkPalindrome(str,i + 1, j - 1);
    }
    public static void main(String[] args) {
        String s = "vasav";
        System.out.println(checkPalindrome(s,0, s.length() - 1));
    }
}
