package dynamic;

public class Leetcode1227 {

    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        //初始化
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) res += dp[i][j] = matrix[i][j];
                else if (matrix[i][j] != 0) {
                    res += dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return res;
    }
}
