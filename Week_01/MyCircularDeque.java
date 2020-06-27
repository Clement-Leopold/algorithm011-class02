/**
 * 循环双端队列；用链表实现
 */
public class MyCircularDeque {

    private final int size;
    private final Node head;
    private final Node end;
    private int total;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        size = k;
        head = new Node(-1);
        end = new Node(-1);
        head.next = end;
        end.prior = head;

    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (total >= size) {
            return false;
        }
        total++;
        Node next = head.next;
        Node newNode = new Node(value);
        next.prior = newNode;
        head.next = newNode;
        newNode.next = next;
        newNode.prior = head;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (total >= size) {
            return false;
        }
        total++;
        Node prior = end.prior;
        Node newNode = new Node(value);
        prior.next = newNode;
        end.prior = newNode;
        newNode.prior = prior;
        newNode.next = end;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (total <= 0) {
            return false;
        }
        total--;
        Node front = head.next;
        front.next.prior = head;
        head.next = front.next;
        front.prior = null;
        front.next = null;
        front = null;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (total <= 0) {
            return false;
        }
        total--;
        Node last = end.prior;
        last.prior.next = end;
        end.prior = last.prior;
        last.prior = null;
        last.next = null;
        last = null;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return head.next.value;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return end.prior.value;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return head.next == end;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return total == size;
    }

    private class Node {
        Node prior;
        Node next;
        Integer value;

        Node(int value) {
            this.value = value;
        }
    }
}
