import java.util.Deque;
import java.util.LinkedList;

/**
 * 用addLast 和 addFirst 改写代码 .
 */
public class ChangeAPI {

    public static void arrayExample() {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size()>0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
    }

    public static void stackExample() {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.peekLast();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size()>0) {
            System.out.println(deque.pollLast());
        }
        System.out.println(deque);
    }

    public static void main(String[] args) {
        arrayExample();
        System.out.println("---------------");
        stackExample();
    }
}
