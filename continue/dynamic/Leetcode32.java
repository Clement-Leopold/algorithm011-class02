package dynamic;

import greed.Leetcode45;

import java.util.LinkedList;

public class Leetcode32 {

    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.poll();
                if (stack.isEmpty()) stack.push(i);
                else max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode32 leetcode32 = new Leetcode32();
        leetcode32.longestValidParentheses("())");
    }
}
