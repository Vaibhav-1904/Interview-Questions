package ImportantQ.ArrayList;
// Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
import java.util.List;

public class MaxDistance {
//    // Naive Approach -> O(n^2)
//    public int maximumGap(final List<Integer> A) {
//        int n = A.size();
//        int ans = 0;
//        for(int i = 0; i < n - 1; i++){
//            for(int j = i+1; j < n; j++){
//                if(A.get(i) <= A.get(j)){
//                    ans = Math.max(ans, j- i);
//                }
//            }
//        }
//        return ans;
//    }

    // Optimal Approach
    public int maximumGap(final List<Integer> A) {
        int n = A.size();
        int[] rightMax = new int[n];
        rightMax[n - 1] = A.get(n - 1);
        for(int i = n - 2; i >= 0; i--) { // Finding the Right Maximum Suffix Matrix
            rightMax[i] = Math.max(rightMax[i + 1], A.get(i));
        }

        int i = 0, j = 0, ans = 0;
        while(i < n && j < n) {
            if(A.get(i) <= rightMax[j]) {
                ans = Math.max(ans, j - i);
                j++;
            }
            else {
                i++;
            }
        }
        return ans;
    }
}
