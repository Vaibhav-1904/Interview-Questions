package ImportantQ.RecursionBacktracking;

import java.util.*;

// https://leetcode.com/problems/combinations/
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        solve(result, new ArrayList<Integer>(), 1, n, k);

        return result;
    }

    void solve(List<List<Integer>> result, List<Integer> row, int index, int n, int k) {
        if(k == 0){
            result.add(new ArrayList<>(row));
            return;
        }

        for(int i = index; i <= n-k+1; i++){
            row.add(i);
            solve(result, row, i + 1, n, k - 1);
            row.remove(row.size() - 1);
        }
    }
}
