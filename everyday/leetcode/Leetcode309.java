package leetcode;

/**
 * 股票含冷冻期
 */
public class Leetcode309 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        // 当天结束 ： 0 持有股票 1 不持有股票 并冷冻 2 不持有股票 非冷冻期
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
