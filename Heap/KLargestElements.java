package ImportantQ.Heap;

import java.util.*;
// https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
public class KLargestElements {
    //Given an array of N positive integers, print k the largest elements from array in decreasing order.

    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for(int i : arr){
            if(pq.size() < k){
                pq.add(i);
            }else if(pq.peek() < i){
                pq.remove();
                pq.add(i);
            }
        }
        return new ArrayList<>(pq);
    }

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
