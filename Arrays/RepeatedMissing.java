package ImportantQ.Arrays;

public class RepeatedMissing {

    int[] findTwoElement(int arr[], int n) {

        int abs_val;
        int[] ans = new int[2];
        for(int i = 0; i < arr.length; i++){
            abs_val = Math.abs(arr[i]);

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
