package ImportantQ.Arrays;

public class RepeatedMissing {
    //Optimal
    int[] findTwoElement(int[] arr, int n) {

        int[] ans = new int[2];
        // ans[0] is repeating number
        // ans[1] is Missing number
        for(int i = 0; i < arr.length; i++){
            int abs_val = Math.abs(arr[i]);

            if(arr[abs_val - 1] > 0){
                arr[abs_val - 1] = -arr[abs_val - 1];
            }
            else{
                ans[0] = abs_val;
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0 ){
                ans[1] = i+1;
            }
        }
        return ans;
    }

}
