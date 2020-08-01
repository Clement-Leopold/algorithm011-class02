public class Leetcode64 {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = grid[n - 1][m - 1];
        for (int i = n - 2; i > -1; i--) {
            dp[i][m - 1] = grid[i][m - 1] + dp[i + 1][m - 1];
        }
        for (int i = m - 2; i > -1; i--) {
            dp[n - 1][i] = grid[n - 1][i] + dp[n - 1][i + 1];
        }
        for (int i = n - 2; i > -1; i--) {
            for (int j = m - 2; j > -1; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Leetcode64 leetcode64 = new Leetcode64();
        leetcode64.minPathSum(input);
    }
}
