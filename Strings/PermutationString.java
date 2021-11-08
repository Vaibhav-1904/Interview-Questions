package ImportantQ.Strings;
// https://leetcode.com/problems/permutation-in-string/
public class PermutationString {
//    // Naive Approach T-> O(n^2)
//    public boolean checkInclusion(String s1, String s2) {
//        if (s1.length() > s2.length())
//            return false;
//        int[] s1map = new int[26];
//        for (int i = 0; i < s1.length(); i++)
//            s1map[s1.charAt(i) - 'a']++;
//
//        for (int i = 0; i <= s2.length() - s1.length(); i++) {
//            int[] s2map = new int[26];
//            for(int j = 0; j < s1.length(); j++)
//                s2map[s2.charAt(i + j) - 'a']++;
//
//            if(matches(s1map, s2map))
//                return true;
//        }
//        return false;
//    }
//
//    public boolean matches(int[] s1map, int[] s2map) {
//        for (int i = 0; i < 26; i++) {
//            if (s1map[i] != s2map[i])
//                return false;
//        }
//        return true;
//    }

    // Optimal
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        //sliding window of size s1.length
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        // count matching characters
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a'; // rightmost char position of sliding window
            int l = s2.charAt(i) - 'a'; // leftmost char position of sliding window
            if (count == 26) // it means any permutation of s1 is present in s2
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1)
                count--;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1)
                count--;
        }
        return count == 26;
    }
}
