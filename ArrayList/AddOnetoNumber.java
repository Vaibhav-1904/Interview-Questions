package ImportantQ.ArrayList;
// Given a non-negative number represented as an array of digits, add 1 to the number
// ( increment the number represented by the digits ).
//The digits are stored such that the most significant digit is at the head of the list.
import java.util.ArrayList;

public class AddOnetoNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        int i = A.size() - 1;

        while(true){
            int lastDigit = A.get(i);
            if(lastDigit == 9){
                A.set(i, 0);
                i--;
            }else{
                A.set(i, lastDigit + 1);
                break;
            }

            if(i == -1){
                A.add(0, 1);
                break;
            }
        }
        while(true){
            if(A.get(0) == 0){
                A.remove(0);
            }else{
                break;
            }
        }

        return A;
    }

}
