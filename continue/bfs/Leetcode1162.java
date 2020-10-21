package bfs;

import java.util.*;

public class Leetcode1162 {


    private static int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maxDistance(int[][] grid) {
        LinkedList<Pair> queue = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) queue.add(new Pair(i, j));
            }
        }
        return bfs(grid, queue, n, m);
    }

    private int bfs(int[][] grid, Deque<Pair> queue, int n, int m) {
        int res = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x, y = pair.y;
            for (int[] dic : directions) {
                int newX = x + dic[0], newY = y + dic[1];
                if (newX < 0 || newX > n - 1 || newY < 0 || newY > m - 1 || grid[newX][newY] != 0) continue;
                res = grid[newX][newY] = grid[x][y] + 1;
                queue.addLast(new Pair(newX, newY));
            }
        }
        return res;
    }

    private class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Leetcode1162 leetcode1162 = new Leetcode1162();
        leetcode1162.maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}});
    }
}
