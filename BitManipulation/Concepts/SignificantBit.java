package ImportantQ.BitManipulation.Concepts;
// Given a number N, find the most significant set bit in the given number,
// Leftmost set bit and then calculate its decimal value.
public class SignificantBit {
    public static void main(String[] args) {
        int n = 10;
        int c = 0;
        while(n != 0){
            n = n >> 1;
            c++;
        }
        c = 1<<--c;
        System.out.println(c);
    }
}
