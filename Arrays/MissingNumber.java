package ImportantQ.Arrays;
import java.util.*;
public class MissingNumber {

    //Input: arr[] = {4, 3, 5, 2, 5, 1}
    //Output: Missing = 6, Repeating = 5

    //First
    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        int i;
        int missing = 0;
        int repeating;

        if(nums[nums.length-1] != nums.length){ //if Last number is missing
            repeating = nums.length - 1;
            missing = nums.length;

            return missing;

        }

        for(i = 0; i < nums.length; i++){
            if(nums[i] !=  i + 1 ){
                missing = i + 1;
                break;
            }
        }
        return missing;
    }
    //Second approach using HashSets or incrementing temp[arr[i]] values from 0->1

    //Optimal
    static int Missing(int[] arr){
        int sum = arr.length * (arr.length +1) / 2;

        for(int i: arr)
            sum -= i;

        return sum;
    }

    public static void main(String[] args){

//        int[] arr = {1,2,3,4,0,6};
//        int miss = Missing(arr);
//        System.out.print(miss);

        //Optimal
        int[] arr1 = {1,3,2,4,5,4};
        int missing = 0;
        int repeating = 0;

        for(int i = 0; i < arr1.length; i++){
            int abs = Math.abs(arr1[i]);
            if(arr1[abs-1] > 0)
                arr1[abs-1] = -arr1[abs-1];
            else{
                repeating = abs;
            }
        }

        for(int i = 0; i  < arr1.length; i++){
            if(arr1[i] > 0)
                missing = i+1;
        }

        System.out.println("Repeating :" + repeating + " Missing : " + missing);
    }
}
