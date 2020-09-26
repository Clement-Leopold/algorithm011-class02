package dynamic;

import java.util.Arrays;

public class Leetcode91 {

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[dp.length - 1] = 1;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == '0') dp[i] = 0;
            else {
                dp[i] = dp[i + 1];
                if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i) < '7'))) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return s.length() == 0 ? 0 : dp[0];
    }

    public int numsDivideAndConqur(String s) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        memo[memo.length - 1] = 1;
        return recursive(s, 0, memo);
    }

    private int recursive(String s, int i, int[] memo) {
        if (memo[i] > -1) return memo[i];
        if (s.charAt(i) == '0') memo[i] = 0;
        else {
            int res = 0;
            res = recursive(s, i + 1, memo);
            if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')))
                res += recursive(s, i + 2, memo);
            memo[i] = res;
        }
        return memo[i];
    }
}
