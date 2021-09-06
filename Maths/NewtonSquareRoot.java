package ImportantQ.Maths;

public class NewtonSquareRoot {
    static double sqRoot(double n, double tolerance){
        double x = n;
        double root;
        int count = 0;
        while(true){
            root = 0.5 * ( x + n/x);
            if(Math.abs(root - x) < tolerance)
                break;
            x = root;
            count++;
        }
        System.out.println(count);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(sqRoot(327, 0.00001 ));
    }
}
