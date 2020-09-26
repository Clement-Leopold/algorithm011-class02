package dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Leetcode322 {

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return divideAndConquer(coins, amount, memo);
    }

    private int divideAndConquer(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount] != 0) return memo[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = divideAndConquer(coins, amount - coin, memo);
            if (res != -1) min = Math.min(min, res + 1);
        }
        return memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
    }

    public int coinChangeDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int coin : coins) {
                dp[i] = i - coin > 0 ? Math.min(dp[i], dp[i - coin] + 1) : dp[i];
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Leetcode322 leetcode322 = new Leetcode322();
        leetcode322.coinChange(new int[]{1, 2, 5}, 11);
    }
}
