package ImportantQ.Arrays;

import java.util.*;

public class SlidingWindow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>(k);
        int[] ans  = new int[n-k+1];

        int i = 0;
        for(; i < n; i++){

            if(i < k){
                while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                    dq.removeLast();
                }
                dq.addLast(i);
            }
            else {
                ans[i-k] = arr[dq.peekFirst()];

                while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                    dq.removeFirst();
                }
                while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                    dq.removeLast();
                }
                dq.addLast(i);
            }
        }

        ans[i-k] = arr[dq.peekFirst()];

        for(int j:ans){
            System.out.print(  j +" ");
        }

    }
}
