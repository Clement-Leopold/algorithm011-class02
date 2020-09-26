package dfs;

public class Leetcode200 {

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    int[][] dics = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length || j > grid[0].length || grid[i][j] == '0') {
            return;
        }
        if (grid[i][j] == '1') grid[i][j] = '0';
        for (int[] dic : dics) dfs(grid, i + dic[0], j + dic[1]);
    }
}

