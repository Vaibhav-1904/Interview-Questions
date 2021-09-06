package ImportantQ.Arrays;

//Consider an array with n elements and value of all the elements is zero. We can perform following operations on the array.
//Incremental operations:Choose 1 element from the array and increment its value by 1.
//Doubling operation: Double the values of all the elements of array.

//We are given desired array target[] containing n elements.
// Compute and return the smallest possible number of the operations needed to change the array from all zeros to desired array.

public class desiredArray {
    public static void main(String[] args) {

        int[] target = {2, 3};
        int count = 0;
        int max = target[0];
        for(int i = 0; i < target.length; i++){

            if((target[i] % 2) != 0){
                target[i]--;
                count++;
            }
            if(target[i] > max){
                max = target[i];
            }
        }

        while(max != 1){
            count++;
            max = max/2;
        }

        count += target.length;

        System.out.println("Count is : " + count);

    }
}
