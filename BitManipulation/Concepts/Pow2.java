package ImportantQ.BitManipulation.Concepts;
// If number is in power of 2 or not
public class Pow2 {



    public static void main(String[] args) {
        int n = 15;

        if(n <= 0)
            System.out.println("False");

        if((n & (n - 1)) == 0) { // AND between 4 and 3, 16 and 15 will always be 0
            System.out.println("Number is EVEN");
        }else
            System.out.println("Number is ODD");

    }
}
