import java.util.Stack;

public class Leetcode32 {
    // stack
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }

    // dp
    public int longestDp(String s) {
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') {
                res = Math.max(dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2, res);
            }
            if (s.charAt(i - 1) == ')' && s.charAt(i) == ')') {
                if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    res = Math.max(dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0), res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "()()(())";
        Leetcode32 leetcode32 = new Leetcode32();
        leetcode32.longestDp(s);
    }
}
