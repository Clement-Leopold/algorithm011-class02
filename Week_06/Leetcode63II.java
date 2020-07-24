
public class Leetcode63II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = 1;
        for (int i = m - 2; i > -1; i--) {
            if (obstacleGrid[n - 1][i] == 1) {
                break;
            }
            dp[n - 1][i] = 1;
        }
        for (int i = n - 2; i > -1; i--) {
            if (obstacleGrid[i][m - 1] == 1) {
                break;
            }
            dp[i][m - 1] = 1;
        }
        for (int i = n - 2; i > -1; i--) {
            for (int j = m - 2; j > -1; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };
        Leetcode63II leetcode63II = new Leetcode63II();
        leetcode63II.uniquePathsWithObstacles(input);
    }
}
