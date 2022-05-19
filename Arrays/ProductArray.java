package ImportantQ.Arrays;
// https://leetcode.com/problems/product-of-array-except-self/
public class ProductArray {
//    // Naive T -> O(n), S -> O(n)
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//
//        int[] prefix = new int[n];
//        int product = 1;
//        for(int i = 0; i < n; i++) {
//            prefix[i] = product;
//            product *= nums[i];
//        }
//
//        int[] suffix = new int[n];
//        product = 1;
//        for(int i = n-1; i >= 0; i--) {
//            suffix[i] = product;
//            product *= nums[i];
//        }
//
//        int[] productArray = new int[n];
//        for(int i = 0; i < n; i++) {
//            productArray[i] = prefix[i] * suffix[i];
//        }
//        return productArray;
//    }

    // optimal T->O(n) S->O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int product = 1;
        int flag = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 0)
                flag++;
            else
                product *= nums[i];
        }

        int[] prod = new int[n];

        for(int i = 0; i < n; i++) {
            if(flag > 1)
                prod[i] = 0;
            else if (flag == 0)
                prod[i] = product / nums[i];
            else if (nums[i] == 0)
                prod[i] = product;
            else
                prod[i] = 0;
        }
        return prod;
    }
}
