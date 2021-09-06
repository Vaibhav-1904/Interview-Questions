package ImportantQ.BinarySearch;
import java.util.*;

//Given an array of integers A of size N and an integer B.
//
//College library has N bags,the ith book has A[i] number of pages.
//
//You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.

//A book will be allocated to exactly one student.
//Each student has to be allocated at least one book.
//Allotment should be in contiguous order,

//Calculate and return that minimum possible number.
//
//NOTE: Return -1 if a valid assignment is not possible.
public class bookAllocation {
    public static boolean isPossible(ArrayList<Integer> A, int n, int pages){

        int sum = 0;
        int student = 1;

        for(int i = 0; i < A.size(); i++){
            if(sum + A.get(i) > pages){
                student++;
                sum = A.get(i);
            }else{
                sum += A.get(i);
            }
        }

        return (student <= n);

    }

    public static int maxOf(ArrayList<Integer> A){
        int max = A.get(0);
        for(int i = 1; i < A.size(); i++){
            if(A.get(i) > max){
                max = A.get(i);
            }
        }
        return max;
    }
    public static int sumOf(ArrayList<Integer> A){
        int sum = 0;
        for (Integer i : A) {
            sum += i;
        }

        return sum;
    }

    public static int books(ArrayList<Integer> A, int n) {
        int res = 0;
        int min = maxOf(A);
        int max = sumOf(A);

        while(min <= max){
            int pages = (min+max)/2;
            if(isPossible(A, n, pages)){
                res = pages;
                max = pages-1;
            }
            else{
                min = pages + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(34);
        arr.add(67);
        arr.add(90);

        int b = books(arr, 2);

        System.out.println(b);

    }
}
