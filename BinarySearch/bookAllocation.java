package ImportantQ.BinarySearch;
import java.util.*;
// https://www.geeksforgeeks.org/allocate-minimum-number-pages/
//Given an array of integers A of size N and an integer B.
//
//College library has N books,and the ith book has A[i] number of pages.
//
//You have to allocate books to B number of students so that maximum number of pages allotted to a student is minimum.

//A book will be allocated to exactly one student.
//Each student has to be allocated at least one book.
//Allotment should be in contiguous order,

//Calculate and return that minimum possible number.
//
//NOTE: Return -1 if a valid assignment is not possible.
public class bookAllocation {
    // T->O(n log n)
    public static int books(ArrayList<Integer> book, int student) {
        int res = 0;
        // Our Answer will lie between min and max
        int min = maxOf(book);
        int max = sumOf(book);

        while(min <= max){
            int pages = (min+max) / 2;
            if(isPossible(book, student, pages)) {
                res = pages;
                max = pages - 1; // if it's possible and since we want to minimize our answer, we can reduce our search
                // space
            }
            else{
                min = pages + 1;
            }
        }

        return res;
    }
    public static boolean isPossible(ArrayList<Integer> book, int n, int pages) {

        int sum = 0;
        int student = 1;

        for(int i = 0; i < book.size(); i++) {
            if(sum + book.get(i) > pages){ // if number of pages allocated to a student increases the middle value(page),
                // allocate current book to new student. Since we don't want our answer > pages
                student++;
                sum = book.get(i);
            }else{
                sum += book.get(i);
            }
        }
        return student <= n; // if total pages are allocated to students <= given value in question
    }

    public static int maxOf(ArrayList<Integer> A) {
        int max = A.get(0);
        for(int i = 1; i < A.size(); i++)
            max = Math.max(max, A.get(i));
        return max;
    }
    public static int sumOf(ArrayList<Integer> A) {
        int sum = 0;
        for (Integer i : A) {
            sum += i;
        }
        return sum;
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
