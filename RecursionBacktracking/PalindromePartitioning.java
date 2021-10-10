package ImportantQ.RecursionBacktracking;
// Given a string s, partition s such that every substring of the partition is a palindrome.
// Return all possible palindrome partitioning of s.
// https://leetcode.com/problems/palindrome-partitioning/
import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        bt(0, s, path, result);
        return result;
    }

    public boolean isPalindrome(String str, int start, int end){
        while(start <= end){
            if(str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }

    public void bt(int index, String str, List<String> path, List<List<String>> result) {
        if(index == str.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < str.length(); i++){
            if(isPalindrome(str, index, i)){
                path.add(str.substring(index, i + 1));
                bt(i + 1, str, path, result);

                //BackTrack
                path.remove(path.size() - 1);
            }
        }
    }

}
