import java.util.Arrays;

/**
 * 不同路径
 */
public class Leetcode62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) dp[m - 1][i] = 1;
        for (int i = 0; i < m; i++) dp[i][n - 1] = 1;
        for (int i = m - 2; i > -1; i--) {
            for (int j = n - 2; j > -1; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public int uniquePathsOneDimension(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = m - 2; i > -1; i--) {
            for (int j = n - 2; j > -1; j--) {
                dp[j] += dp[j + 1];
            }
        }
        return dp[0];
    }
}
