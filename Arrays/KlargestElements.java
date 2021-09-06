package ImportantQ.Arrays;
import java.util.*;
// https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
public class KlargestElements {

    //Given an array of N positive integers, print k largest elements from array in decreasing order.

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        

        for (int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            if(i < k){
                pq.add(arr[i]);
            }
            else {
                if(arr[i] > pq.element()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        ArrayList<Integer> a = new ArrayList<>(pq);
        a.sort(Collections.reverseOrder());

        System.out.println(a);

    }

}
