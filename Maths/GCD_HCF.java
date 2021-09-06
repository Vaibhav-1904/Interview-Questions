package ImportantQ.Maths;

public class GCD_HCF {
    static int hcf(int a, int b){
        if(b == 0)
            return a;
        return hcf(b, a%b);
    }
}
