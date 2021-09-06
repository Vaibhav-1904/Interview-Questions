package ImportantQ.Strings;
// Given an integer n, your task is to complete the function convertToRoman which prints
// the corresponding roman number of n. Various symbols and their values are given below.
// I 1
//V 5
//X 10
//L 50
//C 100
//D 500
//M 1000
public class RomanNumbers {
    String convertToRoman(int n) {

        String[] m = {"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String t = m[n / 1000];
        String h = c[(n % 1000) / 100];
        String tens = x[(n % 100) / 10];
        String ones = i[n % 10];

        return t + h + tens + ones;
    }
}
