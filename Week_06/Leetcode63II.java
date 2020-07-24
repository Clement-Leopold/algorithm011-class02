/**
 * 不同路径II
 */
public class Leetcode63II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = obstacleGrid[i][j];
            }
        }
        for (int i = m - 1; i > -1; i--) {
            if (dp[n - 1][i] != 1) {
                dp[n - 1][i] = 1;
            } else {
                dp[n - 1][i] = 0;
                break;
            }
        }
        for (int i = n - 1; i > -1; i--) {
            if (dp[i][m - 1] != 1) {
                dp[i][m - 1] = 1;
            } else {
                dp[i][m - 1] = 0;
                break;
            }
        }
        for (int i = n - 2; i > -1; i--) {
            for (int j = m - 2; j > -1; j--) {
                if (dp[i][j] != 1) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        Leetcode63II leetcode63II = new Leetcode63II();
        leetcode63II.uniquePathsWithObstacles(input);
    }
}
