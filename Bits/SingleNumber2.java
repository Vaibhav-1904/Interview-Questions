package ImportantQ.Bits;
// Given an array in which all numbers twice except two numbers are repeated once.
// Find those two numbers in the most efficient way.
public class SingleNumber2 {
    static int[] find(int[] arr){
        if(arr.length == 2)
            return arr;

        int xor = 0;
        for(int i:arr)
            xor = (xor ^ i);
        // Now xor stores the xor value of 2 unique elements

        xor = (xor & (-xor));
        // It will give the rightmost set bit of xor,
        // which indicates that at that position, one of the unique elements
        // has unset bit and other has set bit at that position.
        // It will return only the right most set bit in original xor value;

        int a = 0;
        int b = 0;

        // Now since xor contains only the right most set bit, it will differentiate 2 unique elements
        // based on the right most set bit, one with unset bit will give 0 on AND Operation and one
        // with set bit will give more than 0.
        // Other duplicate elements will return to 0 as n ^ n = 0, and thus all duplicates will get
        // nullified.
        for(int i:arr){
            if((xor & i) > 0){
                a = a ^ i;
            }else
                b = b ^ i;
        }
        return new int[]{a, b};
    }
}
