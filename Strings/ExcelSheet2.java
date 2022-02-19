package ImportantQ.Strings;

public class ExcelSheet2 {
    // https://leetcode.com/problems/excel-sheet-column-number/
    public static int titleToNumber(String str) {

        int ans = 0;
        int i = str.length() - 1;
        int x = 0;
        while(i >= 0){
            ans += Math.pow(26, x) * (str.charAt(i) - 'A' + 1);
            i--;
            x++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AZ"));
    }
}
