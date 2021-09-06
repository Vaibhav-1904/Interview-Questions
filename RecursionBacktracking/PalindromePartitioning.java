package ImportantQ.RecursionBacktracking;
// Given a string s, partition s such that every substring of the partition is a palindrome.
// Return all possible palindrome partitioning of s.
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public boolean isPalindrome(String str, int start, int end){
        while(start <= end){
            if(str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }

    public void partition(int index, String str, List<String> path, List<List<String>> result) {
        if(index == str.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < str.length(); i++){
            if(isPalindrome(str, index, i)){
                path.add(str.substring(index, i + 1));
                partition(i + 1, str, path, result);

                //BackTrack
                path.remove(path.size() - 1);
            }
        }
    }

}
