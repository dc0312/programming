package practice.stack;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node {
        Node next;
        Node prev;
        int key;
        int value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int capacity;
    Map<Integer,Node> map;

    LRUCache(int capacity){
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next=tail;
        tail.prev= head;
        map = new HashMap<>();
    }

    public void push(int key, int value){
        Node newNode = new Node(key,value);
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);
        }
        insert(newNode);
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(new Node(key,node.value));
            return node.value;
        }else {
            return -1;
        }
    }

    private void insert(Node newNode) {
        map.put(newNode.key,newNode);
        newNode.next=head.next;
        newNode.next.prev = newNode;
        head.next=newNode;
        newNode.prev = head;
    }

    public void remove(Node node){
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.push(1,1);
        cache.push(2,2);
        System.out.println(cache.get(1));
        cache.push(3,3);
        System.out.println(cache.get(2));
        cache.push(4,4);
        System.out.println(cache.get(1));
    }
}
