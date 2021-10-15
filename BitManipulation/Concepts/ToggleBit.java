package ImportantQ.BitManipulation.Concepts;

public class ToggleBit {

    static int toggle(int val, int n){
        int x = 1 << (n-1);

        return val ^ x;
    }

    static int setBit(int val, int n){
        return val | (1 << (n - 1));
    }

    static int unSetBit(int val, int n){
        return val & ~(1 << (n - 1));
    }

    public static void main(String[] args) {

        System.out.println(toggle(13, 3));
        System.out.println(unSetBit(13, 3));
        System.out.println(setBit(13, 2));
    }
}
