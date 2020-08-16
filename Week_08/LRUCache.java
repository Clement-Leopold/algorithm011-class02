import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Node> hashMap;
    int size;
    final Node head;
    final Node tail;
    int capacity;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        size = 0;
        this.capacity = capacity;
        hashMap = new HashMap<>(capacity);
        head.next = tail;
        tail.front = head;
    }

    public int get(int key) {
        Node node = hashMap.getOrDefault(key, head);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if (node == null) {
            size++;
            node = new Node(key, value);
            hashMap.put(key, node);
            addFirst(node);
        } else {
            node.value = value;
            moveToHead(node);
        }
        if (size > capacity) {
            Node last = tail.front;
            deleteNode(last);
            hashMap.remove(last.key);
            size--;
        }
    }

    private void moveToHead(Node node) {
        if (node == head || node == head.next) {
            return;
        }
        deleteNode(node);
        addFirst(node);
    }

    private void addFirst(Node node) {
        Node oldFirst = head.next;
        node.front = head;
        node.next = oldFirst;
        head.next = node;
        oldFirst.front = node;
    }


    private void deleteNode(Node node) {
        Node front = node.front;
        Node next = node.next;
        front.next = next;
        next.front = front;
    }

    private class Node {
        Node next;
        Node front;
        Integer value;
        Integer key;

        Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        lruCache.get(2);
        lruCache.put(1, 1);
    }
}
