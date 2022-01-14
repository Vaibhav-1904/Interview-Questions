package ImportantQ.Strings;

// https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
public class SmallestDistinctWindow {
//    // Naive Approach
    // T-> O(n^2)  S->O(n)
//    public static String findSubString( String str) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        int n = str.length();
//        for(char c : str.toCharArray()){
//            map.put(c, map.getOrDefault(c, 1));
//        }
//
//        int dist_count = map.size();
//        int min = Integer.MAX_VALUE;
//        String ans = "";
//
//        for(int i = 0; i < n; i++){
//            boolean[] visited = new boolean[256];
//            int count = 0;
//            String subStr = "";
//            for(int j = i; j < n; j++) {
//                if(!visited[str.charAt(j)]){
//                    visited[str.charAt(j)] = true;
//                    count++;
//                }
//                subStr += str.charAt(j);
//                if(count == dist_count)
//                    break;
//            }
//            if(subStr.length() < min && dist_count == count){
//                min = subStr.length();
//                ans = subStr;
//            }
//        }
//        return ans;
//    }

    // Optimal
    public static String findSubString( String str) {
        int n = str.length();
        boolean[] visited = new boolean[256];
        int dist_count = 0;
        for(char c: str.toCharArray()){
            if(!visited[c]){
                visited[c] = true;
                dist_count++;
            }
        }
        int min = Integer.MAX_VALUE;
        int start = 0, start_index = 0;
        int[] cur_count = new int[256];
        int count = 0;

        for(int j = 0; j < n; j++){
            cur_count[str.charAt(j)]++;
            if(cur_count[str.charAt(j)] == 1)
                count++;

            if(count == dist_count){
                while(cur_count[str.charAt(start)] > 1) {
                    cur_count[str.charAt(start)]--;
                    start++;
                }

                int window_len = j - start + 1;
                if(window_len < min){
                    min = window_len;
                    start_index = start;
                }
            }
        }
        return str.substring(start_index, start_index + min);
    }

    public static void main(String[] args) {
        System.out.println(findSubString("aabcbcdbca"));

    }
}
