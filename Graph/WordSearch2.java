package ImportantQ.Graph;
import java.util.*;
// https://leetcode.com/problems/word-search-ii/submissions/
public class WordSearch2 {
//    // Naive Approach  T = O(N^2 * n  +  n*max(len of any word) ) where n is number of words
//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> result = new ArrayList<>();
//
//        for(String str : words){
//            for(int i = 0; i < board.length; i++){
//                for(int j = 0; j < board[i].length; j++){
//
//                    if(board[i][j] == str.charAt(0)){
//                        if(dfs(i, j, board, 0, str))
//                            if(!result.contains(str))
//                                result.add(str);
//                    }
//
//                }
//            }
//        }
//        return result;
//    }
//
//    boolean dfs(int i, int j, char[][] board, int len, String str){
//        if(len == str.length())
//            return true;
//
//        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != str.charAt(len))
//            return false;
//
//        char temp = board[i][j];
//        board[i][j] = ' ';
//
//        boolean found = dfs(i + 1, j, board, len + 1, str)
//                || dfs(i, j + 1, board, len + 1, str)
//                || dfs(i - 1, j, board, len + 1, str)
//                || dfs(i, j - 1, board, len + 1, str);
//
//        board[i][j] = temp;
//        return found;
//    }

    // Optimal T -> O(4^(N^2)) S -> O(N^2)
    static class TrieNode{
        int childs;
        String word;
        TrieNode[] trieNodes = new TrieNode[26];
        TrieNode(){
            childs = 0;
            for(int i = 0; i < 26; i++){
                trieNodes[i] = null;
            }
        }
    }

    void addWord(TrieNode root, String word){
        TrieNode current = root;
        int i = 0;
        while(i < word.length()){
            if(current.trieNodes[word.charAt(i) - 'a'] == null)
                current.trieNodes[word.charAt(i) - 'a'] = new TrieNode();

            current.childs++;
            current = current.trieNodes[word.charAt(i) - 'a'];
            i++;
        }
        current.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for(String word : words)
            addWord(root, word);

        List<String> result = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                dfs(i, j, board, root, result);
            }
        }
        return result;
    }

    void dfs(int i, int j, char[][] board, TrieNode root, List<String> result){
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == ' ' || root.childs == 0 ||
                root.trieNodes[board[i][j] - 'a'] == null)
            return;

        TrieNode child = root.trieNodes[board[i][j] - 'a'];
        if(child.word != null){
            result.add(child.word);
            child.word = null; // So duplicates are not added
        }

        char temp = board[i][j];
        board[i][j] = ' ';

        dfs(i + 1, j, board, child, result);
        dfs(i , j + 1, board, child, result);
        dfs(i - 1, j, board, child, result);
        dfs(i, j - 1, board, child, result);

        board[i][j] = temp;
    }
}
