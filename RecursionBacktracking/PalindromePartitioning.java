package ImportantQ.RecursionBacktracking;
// Given a string s, partition s such that every substring of the partition is a palindrome.
// Return all possible palindrome partitioning of s.
// https://leetcode.com/problems/palindrome-partitioning/

import java.util.*;

public class PalindromePartitioning {

    // Recusrive Approach T -> O(2^n * n)
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Partition(0, s, path, result);
        
        return result;
    }
    
    public static void Partition(int index, String str, List<String> path, List<List<String>> result){
        if(index == str.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index; i < str.length(); i++){
            if(isPalindrome(str, index, i)){
                path.add(str.substring(index, i + 1));
                Partition(i + 1, str, path, result);
                
                path.remove(path.size() - 1);
            }
        }
    }
    
    public static boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    // // Optimal -> Dp
    // public List<List<String>> partition(String s) {
    //     int n = s.length();
        
    //     List<List<String>> result = new ArrayList<>();
    //     List<String> path = new ArrayList<>();
        
    //     boolean[][] dp = new boolean[n][n];
        
    //     for(int i = 0; i < n; i++){
    //         for(int j = 0; j <= i; j++){
    //             if(s.charAt(i) == s.charAt(j)){
    //                 if(i == j)
    //                     dp[j][i] = true;
    //                 else if(i - j == 1)
    //                     dp[j][i] = true;
    //                 else if(dp[j + 1][i - 1])
    //                     dp[j][i] = true;
    //             }
    //         }
    //     }
    //     Partition(0, s, path, result, dp);
        
    //     return result;
    // }
    
    // void Partition(int index, String str, List<String> path, List<List<String>> result, boolean[][] dp){
    //     if(index == str.length()){
    //         result.add(new ArrayList<>(path));
    //         return;
    //     }
        
    //     for(int i = index; i < str.length(); i++){
    //         if(dp[index][i]){
    //             path.add(str.substring(index, i + 1));
    //             Partition(i + 1, str, path, result, dp);
                
    //             path.remove(path.size() - 1);
    //         }
    //     }
    // }

    public static void main(String[] args) {
        System.out.println(partition("abbaa"));
    }
}
