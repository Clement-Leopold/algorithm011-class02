package dynamic;

import java.util.Arrays;

public class Leetcode91 {

    public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        memo[memo.length - 1] = 1;
        recur(s, 0, memo);
        return memo[0];
    }

    private int recur(String s, int i, int[] memo) {
        if (memo[i] > -1) return memo[i];
        if (s.charAt(i) == '0') {
            memo[i] = 0;
            return 0;
        }
        int res = 0;
        res = recur(s, i + 1, memo);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
            res += recur(s, i + 2, memo);
        memo[i] = res;
        return res;
    }

    public static void main(String[] args) {
        String s = "17";
        Leetcode91 leetcode91 = new Leetcode91();
        leetcode91.numDecodings(s);
    }
}

