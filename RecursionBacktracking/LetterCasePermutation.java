package ImportantQ.RecursionBacktracking;
import java.util.*;

// https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder(s);

        backtrack(result, str, 0);

        return result;
    }

    public void backtrack(List<String> result, StringBuilder str, int index){
        if(index == str.length()){
            result.add(str.toString());
            return;
        }

        char c = str.charAt(index);
        if(Character.isLetter(c)){
            str.setCharAt(index, Character.toLowerCase(c));
            backtrack(result, str, index + 1);
            str.setCharAt(index, Character.toUpperCase(c));
            backtrack(result, str, index + 1);
            str.setCharAt(index, c);
        }else{
            backtrack(result, str, index + 1);
        }
    }
}
