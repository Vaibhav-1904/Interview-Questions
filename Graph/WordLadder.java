package ImportantQ.Graph;
import java.util.*;
// https://leetcode.com/problems/word-ladder/submissions/
// BFS Traversal
public class WordLadder {
    // T -> O(N * M * 26) where N is number of words and M is length(word)
    public int ladderLength(String startWord, String endWord, List<String> wordList) {
        Set<String> list = new HashSet<>(wordList); // set because of it's fast operations in O[1] time complexity
        if(!list.contains(endWord)) // if end is not present in dictionary
            return 0;

        int n = startWord.length();
        Queue<String> q = new LinkedList<>();
        q.add(startWord);
        int ans = 0;

        while(!q.isEmpty()){
            ans++;
            int size = q.size();

            for(int i = 0; i < size; i++){

                char[] str = q.poll().toCharArray();

                for(int j = 0; j < n; j++){
                    char c = str[j];

                    for(char k = 'a'; k <= 'z'; k++){
                        str[j] = k;

                        if(endWord.equals(String.valueOf(str))) // if we have found our string
                            return ans + 1;

                        if(list.contains(String.valueOf(str))){
                            q.offer(String.valueOf(str));
                            list.remove(String.valueOf(str));
                        }
                    }
                    str[j] = c;
                }
            }
        }
        return 0;
    }
}
