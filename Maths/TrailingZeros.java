package ImportantQ.Maths;
// Find number of trailing zeros in a factorial
public class TrailingZeros {
    public static int find(int n){
        return 2 * (n / 10) + (n % 10) / 5;
    }

    public static void main(String[] args) {
        System.out.println(find(15));
    }
}
