package dynamic;

import java.util.LinkedList;

public class Leetcode32 {


    public int longestValidParenthesesInDp(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.poll();
                if (stack.isEmpty()) stack.push(i);
                else max = Math.max(i - stack.peek(), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode32 leetcode32 = new Leetcode32();
        leetcode32.longestValidParentheses("())");
    }
}
