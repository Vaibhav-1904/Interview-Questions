package ImportantQ.ArrayList;
import java.util.ArrayList;
import java.util.List;
// Given an integer numRows, return the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

public class PascalTriangle {
    public static List<List<Integer>> generate(int n) {
        // n = Number of Rows in Triangle
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row, pre = null;
        for (int i = 0; i < n; i++) {
            row = new ArrayList<Integer>();

            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    row.add(1);
                } else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = new ArrayList<Integer>(row);
            ans.add(row);
        }
        return ans;
    }

    public static int factorial(int f){
        if(f == 1)
            return f;

        else
            return f * factorial(f-1);
    }

    public static void main(String[] args){

        System.out.print(factorial(6));
    }
}
