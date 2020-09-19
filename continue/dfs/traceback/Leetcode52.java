package dfs.traceback;

public class Leetcode52 {

    public int totalNQueens(int n) {
        return dfs(new boolean[2 * n], new boolean[2 * n], new boolean[n], 0, n, 0);
    }

    private int dfs(boolean[] d1, boolean[] d2, boolean[] col, int r, int n, int count) {
        if (r == n) count++;
        else {
            for (int c = 0; c < n; c++) {
                int diag1 = r + c, diag2 = r - c + n;
                if (!d1[diag1] && !d2[diag2] && !col[c]) {
                    d1[diag1] = true;
                    d2[diag2] = true;
                    col[c] = true;
                    count = dfs(d1, d2, col, r + 1, n, count);
                    d1[diag1] = false;
                    d2[diag2] = false;
                    col[c] = false;
                }
            }
        }
        return count;
    }
}
