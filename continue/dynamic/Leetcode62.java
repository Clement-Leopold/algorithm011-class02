package dynamic;

public class Leetcode62 {


    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        return unique(0, 0, m, n, res);
    }

    // 分治
    private int unique(int i, int j, int m, int n, int[][] res) {
        if (i == m - 1) return 1;
        if (j == n - 1) return 1;
        if (res[i][j] > 0) return res[i][j];
        res[i][j] = unique(i + 1, j, m, n, res) + unique(i, j + 1, m, n, res);
        return res[i][j];
    }

    // dp
    public int dp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][n - 1] = 1;
        for (int i = 0; i < n; i++) dp[m - 1][i] = 1;
        for (int i = m - 2; i > 0; i--) {
            for (int j = n - 2; j > 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
