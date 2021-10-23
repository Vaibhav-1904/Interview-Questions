package ImportantQ.Stack;
import java.util.HashMap;
import java.util.Map;
//  https://leetcode.com/problems/lru-cache/
public class LRUCache {
    // Doubly LinkedList
    public static class Node{
        int key, value;
        Node pre, next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int c) {
        capacity = c;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
            insert(temp);
            return temp.value;
        }else
            return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.pre);
        }

        insert(new Node(key, value));
    }

    public void remove(Node temp){
        map.remove(temp.key);
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;
    }

    public void insert(Node temp){
        map.put(temp.key, temp);
        temp.next = head.next;
        head.next.pre = temp;
        head.next = temp;
        temp.pre = head;
    }
}
