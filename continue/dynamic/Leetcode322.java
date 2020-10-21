package dynamic;

import java.util.Arrays;
import java.util.Random;

public class Leetcode322 {

    public int coinChangeIteration(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    int[] memo = new int[10 * 10 * 10 * 10 + 1];

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount] != 0) return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int value = coinChange(coins, amount - coin) + 1;
            res = value > 0 ? Math.min(value, res) : res;
        }
        return memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
    }


    public static void main(String[] args) {
        Leetcode322 leetcode322 = new Leetcode322();
        leetcode322.coinChange(new int[]{1, 2, 5}, 11);
    }
}
