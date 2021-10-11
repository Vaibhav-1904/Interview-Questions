package ImportantQ.Arrays;
import java.util.Scanner;

//Find the Number of contiguous arithmetic array elements in a given array :
// Eg in 1,2,3,4,90,100,7,8  -> Ans is 4 as there are four continuous elements
// Eg 1,2,3,4

public class ArithmeticSubArray {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] arr = {2, 4, 6, 8, 10, 90, 100, 7, 8};
        int n = arr.length;

        //Main Code

        int diff = arr[1] - arr[0];
        int counter2 = 1;
        int counter1 = 0;
        int i = 2;


        while(i < n)
        {
            if(diff == (arr[i] - arr[i - 1]) )
            {
                counter2++;
            }
            else
            {
                if(counter2 > counter1)
                {
                    counter1 = counter2;
                    counter2 = 1;
                    diff = arr[i] - arr[i-1];
                }
            }
            i++;
        }
        if(counter2 > counter1)
            counter1 = counter2;

        counter1 += 1;

        System.out.println("Number of contiguous arithmetic array elements are : " +  counter1);
    }
}
