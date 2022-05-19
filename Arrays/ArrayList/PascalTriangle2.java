package ImportantQ.Arrays.ArrayList;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle-ii/
public class PascalTriangle2 {
   // // Optimal
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        rowIndex++;
        long num = 1;
        for (int i = 1; i <= rowIndex; i++) {
            result.add((int)num);
            num = num * (rowIndex - i) / i;
        }
        return result;
    }
}
