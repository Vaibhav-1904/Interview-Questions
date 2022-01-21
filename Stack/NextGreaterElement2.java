package ImportantQ.Stack;
import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-ii/
// Find Next Greater Element in right of Circular array
public class NextGreaterElement2 {
    static int count = 0;
//    // Naive T -> O(n^2)
//    public int[] nextGreaterElements(int[] nums) {
//        int n = nums.length;
//        int[] result = new int[n];
//        boolean flag = false;
//        for(int i = 0; i < n; i++){
//            flag = false;
//            for(int j = i + 1; j < i + n; j++){
//                if(nums[j % n] > nums[i]){
//                    result[i] = nums[j % n];
//                    flag = true;
//                    break;
//                }
//            }
//            if(!flag)
//                result[i] = -1;
//        }
//        return result;
//    }

    // Optimal Approach T -> O(2n + 2n) = N
    // Since the while loop does not always run it does not take extra square time
    public static int[] nextGreaterElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result = new int[n];

        for(int i = 2*n - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[i % n] >= stack.peek()){
                stack.pop();
                count++; // for noting down how many times this loop runs
            }
            if(i < n){
                if(!stack.isEmpty())
                    result[i] = stack.peek();
                else
                    result[i] = -1;
            }
            stack.push(arr[i % n]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] result = nextGreaterElements(arr);

        System.out.println(Arrays.toString(result));
    }
}
