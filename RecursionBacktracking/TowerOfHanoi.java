package ImportantQ.RecursionBacktracking;
// Shift 'n-1' disks from 'A' to 'B'.
//Shift last disk from 'A' to 'C'.
//Shift 'n-1' disks from 'B' to 'C'.
public class TowerOfHanoi {
    public static void count(int n, char fromRod, char toRod, char midRod){
        if(n == 1){
            System.out.println("Move Disk 1 from " + fromRod + " to " + toRod);
            return;
        }
        count(n - 1, fromRod, midRod, toRod);
        System.out.println("Move Disk " + n + " from " + fromRod + " to " + toRod);
        count(n - 1, midRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        count(3, 'A', 'C', 'B');
    }
}
