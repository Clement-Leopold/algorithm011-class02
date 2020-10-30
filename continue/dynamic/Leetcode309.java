package dynamic;

/**
 * 股票含冷冻期
 */
public class Leetcode309 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        // 0 未持有股票处于冷冻期 1 未持有股票未冷冻 2 持有股票
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][2] + prices[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][2] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}

