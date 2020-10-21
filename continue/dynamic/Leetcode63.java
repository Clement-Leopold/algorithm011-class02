package dynamic;

public class Leetcode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] aux = new int[n][m];
        aux[n - 1][m - 1] = obstacleGrid[n - 1][m - 1] == 1 ? 0 : 1;
        for (int i = n - 2; i > 0; i++) aux[i][m - 1] = obstacleGrid[i][m - 1] == 1 || aux[i + 1][m - 1] == 0 ? 0 : 1;
        for (int i = m - 2; i > 0; i++) aux[n - 1][i] = obstacleGrid[n - 1][i] == 1 || aux[n - 1][i + 1] == 0 ? 0 : 1;
        for (int i = n - 2; i > -1; i--) {
            for (int j = m - 2; j > -1; j--) {
                aux[i][j] = obstacleGrid[i][j] == 1 ? 0 : (aux[i + 1][j] + aux[i][j + 1]);
            }
        }
        return aux[0][0];
    }
}
