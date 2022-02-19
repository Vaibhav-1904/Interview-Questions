package ImportantQ.Stack;
import java.util.HashMap;
import java.util.Map;
// https://www.youtube.com/watch?v=xDEuM5qa0zg
//  https://leetcode.com/problems/lru-cache/
public class LRUCache {
    // Doubly LinkedList
    public static class Node {
        int key, value;
        Node pre, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Node> cache;
    int capacity;

    public LRUCache(int c) {
        cache = new HashMap<>();
        capacity = c;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node temp = cache.get(key);
            remove(temp);
            insert(temp);
            return temp.value;
        }else
            return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        if(cache.size() == capacity){
            remove(tail.pre);
        }
        insert(new Node(key, value));
    }

    public void remove(Node temp){
        cache.remove(temp.key);
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;
    }

    public void insert(Node temp){
        cache.put(temp.key, temp);
        temp.next = head.next;
        head.next.pre = temp;
        head.next = temp;
        temp.pre = head;
    }
}
