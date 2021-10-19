package ImportantQ.Strings;
// Given a positive integer N, return its corresponding column title as it would appear in an Excel sheet.
//For N =1 we have column A, for 27 we have AA and so on.
// https://leetcode.com/problems/excel-sheet-column-title/
//Note: The alphabets are all in uppercase.
public class ExcelSheet1 {
//    T -> O(longn)
    public String excelColumn(int N){
        StringBuilder ans = new StringBuilder();
        while(N > 0){
            int rem = N % 26;
            if(rem == 0){
                ans.append("Z");
                N = (N / 26) - 1; // Because Floor value increases by 1 when rem is 0
            }else{
                ans.append((char)( (rem - 1) + 'A') );
                N /= 26;
            }
        }
        return ans.reverse().toString();
    }
}
