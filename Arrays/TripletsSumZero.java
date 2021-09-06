package ImportantQ.Arrays;

import java.util.Arrays;

//Two Pointer Algorithm -> Given an array of integers. Check whether it contains a triplet that sums up to zero.
public class TripletsSumZero {

    public boolean findTriplets(int arr[] , int n)
    {
        Arrays.sort(arr);

        for(int i = 0; i < n-2; i++){
            int sum = arr[i] * -1;

            if(twoSum(arr, sum, i+1, n-1)){
                return true;
            }
        }
        return false;
    }
    public boolean twoSum(int[] arr, int sum, int i, int j){

        while(i < j){
            if((arr[i] + arr[j]) > sum){
                j--;
            }else if((arr[i] + arr[j]) < sum){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
