package ImportantQ.Strings;
// https://leetcode.com/problems/multiply-strings/
// Given two numbers as stings s1 and s2. Calculate their Product.
public class MultiplyNumbers {
    public static String multiplyStrings(String num1, String num2)
    {
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        boolean sign = false;
        if(num1.charAt(0) == '-' && num2.charAt(0) == '-'){
            sign = true;
            num1 = num1.substring(1);
            num2 = num2.substring(1);
        }else if(num1.charAt(0) == '-'){
            num1 = num1.substring(1);
        }else if(num2.charAt(0) == '-'){
            num2 = num2.substring(1);
        }else{
            sign = true;
        }

        int n1 = num1.length();
        int n2 = num2.length();
        int[] ans = new int[n1 + n2];

        int i = n2 - 1;
        int x = 0;

        while(i >= 0){
            int ival = num2.charAt(i) - '0';
            i--;

            int j = n1 - 1;
            int k = ans.length - x - 1;// if we multiply with second digit from left in second number with the above number, we leave 1 space(0), x is used to denote that property
            int carry = 0;

            while(j >= 0 || carry != 0){
                int jval = j >= 0 ? num1.charAt(j) - '0' : 0; // if multiplication is over but carry is still there, int that case j = -1
                // if j is out of index the jval  = 0
                j--;

                int product = ival * jval + carry + ans[k];

                ans[k] = product % 10;
                carry = product / 10;
                k--;
            }
            x++;
        }
        StringBuilder str = new StringBuilder();
        if(!sign){
            str.append("-");
        }
        boolean flag = false;
        for(int digit : ans){
            if(digit == 0 && !flag){
                //Leading Zeros
            }else{
                flag = true;
                str.append(digit);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {

        System.out.println("Ans : " + multiplyStrings("4416", "-333"));
    }
}
