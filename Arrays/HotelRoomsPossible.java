package ImportantQ.Arrays;
// A hotel manager has to process N advance bookings of rooms for the next season.
// His hotel has C rooms. Bookings contain an arrival date and a departure date.
// He wants to find out whether there are enough rooms in the hotel to satisfy the demand.
// Write a program that solves this problem in time O(N log N) .
// https://www.geeksforgeeks.org/find-k-bookings-possible-given-arrival-departure-times/
import java.util.*;

// Eg -  A = [1, 3, 5]
// B = [2, 6, 8]
// C = 1
// Output = False
public class HotelRoomsPossible {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        Collections.sort(arrive);
        Collections.sort(depart);
        int roomsRequired = 0, i = 0, j = 0;
        // To check how many overlaps are present
        while(i < arrive.size()  && j < arrive.size() && roomsRequired <= K){
            if(arrive.get(i) < depart.get(j) ){
                i++;
                roomsRequired++;
            }else{
                j++;
                roomsRequired--;
            }
        }
        return roomsRequired <= K;
    }
}
