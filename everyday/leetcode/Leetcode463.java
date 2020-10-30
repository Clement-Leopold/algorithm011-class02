package leetcode;

public class Leetcode463 {

    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] aux = new int[n + 2][m + 2];
        int index = 1, res = 0;
        for (int[] line : grid) System.arraycopy(line, 0, aux[index++], 1, line.length);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (aux[i][j] == 1) {
                    // 上面一行
                    if (aux[i - 1][j] == 0) res++;
                    //下面一行
                    if (aux[i + 1][j] == 0) res++;
                    // 左边一列
                    if (aux[i][j - 1] == 0) res++;
                    // 右边一列
                    if (aux[i][j + 1] == 0) res++;
                }
            }
        }
        return res;
    }
}
