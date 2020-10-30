package dynamic;

import java.util.Arrays;

public class Leetcode518 {

    int[] memo;

    public int change(int amount, int[] coins) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int n = coins.length;

    }

    private int helper(int amount, int[] coins) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (memo[amount] != -1) return memo[amount];
        int result = 1;
        for (int coin : coins) {
            int res = helper(amount - coin, coins);
            if (res > 0) result *= res;
        }
        return result;
    }

}
