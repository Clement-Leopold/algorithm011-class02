package dynamic;

import java.util.LinkedList;

public class Leetcode32 {

    public int longestValidParentheses(String s) {
        int max = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') linkedList.push(i);
            else {
                linkedList.poll();
                if (linkedList.isEmpty()) linkedList.push(i);
                else max = Math.max(i - linkedList.peek(), max);
            }
        }
        return max;
    }

    public int longestValidParenthesesInDp(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                else if (i - dp[i - 1] - 1 > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (i - dp[i - 1] - 2 >= 0) dp[i] += dp[i - dp[i - 1] - 2];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
