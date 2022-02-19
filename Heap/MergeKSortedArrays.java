package ImportantQ.Heap;
import java.util.*;
// https://www.geeksforgeeks.org/merge-k-sorted-arrays/
// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedArrays {
//    // Naive Approach , T = O(n*k + n*k*log(n*k))
//    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K)
//    {
//        ArrayList<Integer> result = new ArrayList<>();
//
//        for(int[] i: arr){
//            for(int j:i){
//                result.add(j);
//            }
//        }
//        Collections.sort(result);
//        return result;
//    }

//     Priority Queue -> Better Approach
//    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K)
//    {
//        // Write your code here.
//        ArrayList<Integer> result = new ArrayList<>();
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//
//        for(int[] i: arr){
//            for(int j:i)
//                minHeap.add(j);
//        }
//
//        while(!minHeap.isEmpty())
//            result.add(minHeap.remove());
//
//        return result;
//    }

    // Priority Queue -> Optimal Approach
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);

        // Adding all first values of different LinkedLists
        for(ListNode head: lists) {
            if(head != null)
                minHeap.add(head);
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;

        while(!minHeap.isEmpty()){
            ListNode current = minHeap.poll();
            // Creating Final List
            temp.next = current;
            temp = temp.next;

            if(current.next != null)
                minHeap.offer(current.next);
        }
        return head.next;
    }

    static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val){
           this.val = val;
       }
       ListNode(int val, ListNode next){
           this.val = val; this.next = next;
       }
   }
}
