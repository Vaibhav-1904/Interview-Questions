package ImportantQ.Strings;

import java.util.*;

// https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/
public class NonRepeatingChar {
    // Input 1: "abadbc"
    // Output 1: "aabbdd"



    // Optimal Approach
    static class ListNode{
        char c;
        ListNode pre;
        ListNode next;
        ListNode(char c){
            this.pre = this.next = null;
            this.c = c;
        }
    }
    public static ListNode head;
    public static ListNode cur;


//    // Naive
//    public static String solve(String str) {
//        StringBuilder result = new StringBuilder();
//
//
//        int[] count = new int[26];
//        Queue<Character> q = new LinkedList<>();
//
//        for(char c : str.toCharArray()) {
//
//            count[c - 'a']++;
//            if(count[c - 'a'] == 1)
//                q.add(c);
//
//            while(!q.isEmpty() && count[q.peek() - 'a'] > 1)
//                q.poll();
//
//            if(!q.isEmpty())
//                result.append(q.peek());
//            else
//                result.append('#');
//        }
//
//        return result.toString();
//    }

    public static String solve(String str) { // aabc
        ListNode[] stream = new ListNode[26];
        boolean[] repeated = new boolean[26];

        StringBuilder result = new StringBuilder();
        for(char c : str.toCharArray()) {
            int index = c - 'a';

            if(repeated[index])
                continue;
            else if(stream[index] != null){
                repeated[index] = true;
                head = removeCharacter(c);
            }else{
                if(head == null){
                    head = new ListNode(c);
                    cur = head;
                    stream[index] = head;
                }else {
                    cur.next = new ListNode(c);
                    cur.next.pre = cur;
                    cur = cur.next;
                    stream[index] = cur;
                }
            }

            if(head == null)
                result.append('#');
            else
                result.append(head.c);
        }
        return result.toString();
    }

    public static ListNode removeCharacter(char c) {
        ListNode temp = head;
        while(temp != null){
            if(temp.c == c) {
                if(temp.pre == null && temp.next == null)
                    return null;

                if(temp.pre == null)
                    return temp.next;

                if(temp.next == null){
                    temp.pre.next = null;
                    return head;
                }

                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;

                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(solve("abadbc"));
    }
}
