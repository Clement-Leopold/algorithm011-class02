package leetcode;

public class Leetcode52 {

    int res = 0;

    public int totalNQueens(int n) {
        dfs(new boolean[2 * n] , new boolean[2 * n], new boolean[n],0, n);
        return res;
    }

    private void dfs(boolean[] diag1, boolean[] diag2, boolean[] col, int row, int n) {
        if (row == n) res++;
        else for (int c = 0; c < n; c++) {
            int dg1 = row + c, dg2 = row - c + n;
            if (!diag1[dg1] && !diag2[dg2] && !col[c]) {
                diag1[dg1] = true; diag2[dg2] = true; col[c] = true;
                dfs(diag1, diag2, col, row + 1, n);
                diag1[dg1] = false; diag2[dg2] = false; col[c] = false;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode52 leetcode52 = new Leetcode52();
        leetcode52.totalNQueens(1);
    }
}
