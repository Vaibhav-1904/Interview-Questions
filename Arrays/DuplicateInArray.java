package ImportantQ.Arrays;
//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//There is only one repeated number in nums, return this repeated number.
//
//You must solve the problem without modifying the array nums and uses only constant extra space.

public class DuplicateInArray {
    int findDuplicate(int[] arr) {

        int slow = arr[0];
        int fast = arr[0];
        do //This loop will create a circular loop and will stop at a point where slow and fast meet
        {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Find the "entrance"
        // to the cycle.
        slow = arr[0];

        while(slow != fast){
            fast = arr[fast];
            slow = arr[slow];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5 , 6, 3};
        int slow = arr[0];
        int fast = arr[0];
        do //This loop will create a circular loop and will stop at a point where slow and fast meet
        {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        System.out.println("Slow is : " + slow + " and Fast is : " + fast);
    }
}
