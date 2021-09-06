package ImportantQ.Strings;
import java.util.*;
// Write a program to Validate an IPv4 Address. The generalized form of an IPv4 address is (0-255).(0-255).(0-255).(0-255).
// Here we are considering numbers only from 0 to 255 and any additional leading zeroes will be considered invalid.

public class IPAddress4 {
    public boolean isValid(String s){
        int n = s.length();

        int count = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '.'){
                count++;
            }
        }
        if(count != 3) return false;

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < 256; i++){
            set.add(String.valueOf(i));
        }
        StringBuilder ans = new StringBuilder();

        count = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '.'){
                if(set.contains(ans.toString())){
                    count++;
                }
                ans.delete(0, ans.length());

            }else{
                ans.append(s.charAt(i));
            }
        }
        if(set.contains(ans.toString())){
            count++;
        }
        return count == 4;
    }
}
