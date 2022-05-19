package ImportantQ.Arrays.ArrayList;
// https://www.interviewbit.com/problems/add-one-to-number/
// https://leetcode.com/problems/plus-one/
// Given a non-negative number represented as an array of digits, add 1 to the number
// ( increment the number represented by the digits ).
//The digits are stored such that the most significant digit is at the head of the list.
import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int i = A.size() - 1;
        while(true) {
            int lastDigit = A.get(i);
            if(lastDigit == 9) {
                A.set(i, 0);
                i--;
            }else {
                A.set(i, lastDigit + 1);
                break;
            }

            if(i == -1) {
                A.add(0, 1);
                break;
            }
        }
        while(true) {
            if(A.get(0) == 0){
                A.remove(0);
            }else{
                break;
            }
        }

        return A;
    }

    // Optimal
    public static int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            }else
                digits[i] = 0;
        }
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {8, 8, 9};

        System.out.println(Arrays.toString(plusOne(arr)));
    }
}
