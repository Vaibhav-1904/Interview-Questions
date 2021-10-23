package ImportantQ.Stack;
import java.util.Stack;
// Find Next Smaller Element in right of Circular array
public class NextSmallerElement {
    public static int[] nextSmallerElements(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 2*n - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[i % n] <= stack.peek())
                stack.pop();
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
        int[] arr = {5, 4 , 3 , 2, 6};
        int[] result = nextSmallerElements(arr);
        for(int i:result)
            System.out.print(i + " ");
    }
}
