/**
 * 岛屿数量
 */
public class Leetcode200NumberOfIsland {
    int ans = 0;
    int[][] direct = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j > grid[0].length - 1) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            for (int[] dir : direct) {
                dfs(grid, i + dir[0], j + dir[1]);
            }
        }
    }
}
