package ImportantQ.Strings.DynamicStrings;

import java.util.*;

public class StringBuilderClass {
    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>();
//
//        arr.add(30);
//        arr.add(5);
//        arr.add(9);
//
//        String ij = arr.get(0).toString().concat(arr.get(1).toString());
//        String ji = arr.get(1).toString().concat(arr.get(0).toString());
//        System.out.println("Which is Greater : " + ij.compareTo(ji));
//
//        StringBuilder sb = new StringBuilder("");
//
//        String a = "00000";
//        int b = Integer.parseInt(a);
//        sb.append("0");
//        System.out.println(sb.charAt(0));

//        StringBuilder s = new StringBuilder("Vaibhav");
//        s.insert(1, "Patel");
//        System.out.println(s);

        String c = "85";
        String a = "9";
        String b = "30";
        ArrayList<String> arr = new ArrayList<>();
        arr.add(c);
        arr.add(a);
        arr.add(b);
        Collections.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        System.out.println(arr);


    }
}
