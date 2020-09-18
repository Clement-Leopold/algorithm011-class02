import java.nio.charset.CharsetEncoder;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// 解码
public class Leetcode394 {

    public String decodeString(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) deque.offer(c);
        return helper(deque);
    }

    private String helper(Deque<Character> deque) {
        int number = 0;
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            char c = deque.poll();
            if (c == '[') {
                String res = helper(deque);
                for (int i = 0; i < number; i++) builder.append(res);
                number = 0;
            } else if (Character.isDigit(c)) number = number * 10 + c - '0';
            else if (c == ']') break;
            else builder.append(c);
        }
        return builder.toString();
    }


    public String decodeStringStack(String s) {
        Stack<String> res = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        int index = 0;
        String result = "";
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int number = s.charAt(index) - '0';
                while (Character.isDigit(s.charAt(++index))) number = number * 10 + s.charAt(index) - '0';
                numbers.push(number);
            } else if (s.charAt(index) == '[') {
                res.push(result);
                result = "";
                index++;
            } else if (s.charAt(index) == ']') {
                String temp = res.pop();
                int number = numbers.pop();
                for (int i = 0; i < number; i++) temp += result;
                result = temp;
                index++;
            } else result += s.charAt(index++);
        }
        return result;
    }


}
