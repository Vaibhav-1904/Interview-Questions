package ImportantQ.Arrays;
// https://leetcode.com/problems/max-chunks-to-make-sorted/
public class MaxChunksArraySorted {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int n = arr.length;
        int maxIndex = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] == i)
                count++;
            else{
                maxIndex = arr[i];
                while(i <= maxIndex){
                    if(arr[i] > maxIndex)
                        maxIndex = arr[i];
                    else
                        i++;
                }
                i--;
                count++;
            }
        }
        return count;
    }
}
