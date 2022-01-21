package ImportantQ.Strings;

import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
// Input: aaabc
//Output: abaca
public class RearrangeCharacters {
    static class Freq{
        int f;
        char c;
        Freq(char c, int f){
            this.f = f;
            this.c = c;
        }
    }

    public static String Rearrange(String str) {

        PriorityQueue<Freq> pq = new PriorityQueue<>((one, two) -> two.f - one.f);
        int[] count = new int[26];

        for(char c : str.toCharArray())
            count[c - 'a']++;

        for(char c = 'a'; c <= 'z'; c++){
            int val = c - 'a';
            if(count[val] > 0)
                pq.add(new Freq(c, count[val]));
        }

        StringBuilder result = new StringBuilder();
        Freq pre = new Freq('#', 0);
        while(!pq.isEmpty()) {
            Freq letter = pq.poll();
            result.append(letter.c);

            if(pre.f > 0)
                pq.add(pre);

            letter.f--;
            pre = letter;
        }

        if(result.length() == str.length())
            return result.toString();
        else
            return "Not Possible";
    }

    public static void main(String[] args) {
        String str = "aaabc";
        System.out.println(Rearrange(str));
    }
}
