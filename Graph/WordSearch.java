package ImportantQ.Graph;
// https://leetcode.com/problems/word-search/submissions/
public class WordSearch {
    // T = O(N^2 + len(word)) auxiliary S = O(len(word))
    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int i, int j, int len, String word) {
        if(len == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(len))
            return false;

        char temp = board[i][j];
        board[i][j] = ' '; //  because you cannot use same character twice

        boolean found = dfs(board, i + 1, j, len + 1, word)
                || dfs(board, i, j + 1, len + 1, word)
                || dfs(board, i - 1, j, len + 1, word)
                || dfs(board, i, j - 1, len + 1, word);

        board[i][j] = temp;
        return found;
    }
}
