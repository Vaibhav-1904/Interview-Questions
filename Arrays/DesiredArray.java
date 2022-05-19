package ImportantQ.Arrays;
// https://www.geeksforgeeks.org/count-minimum-steps-get-given-desired-array/
//Consider an array with n elements and value of all the elements is zero. We can perform following operations on the array.
//Incremental operations:Choose 1 element from the array and increment its value by 1.
//Doubling operation: Double the values of all the elements of array.

//We are given desired array target[] containing n elements.
// Compute and return the smallest possible number of the operations/steps needed to change the array from all zeros to desired array.

public class DesiredArray {
    int countMinOperations(int[] target, int n) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < target.length; i++) {
            if((target[i] % 2) != 0){
                target[i]--;
                count++;
            }
            max = Math.max(target[i], max);

        }
        while(max != 1){
            count++;
            max = max >> 1;
        }
        count += target.length;

        return count;
    }
}
