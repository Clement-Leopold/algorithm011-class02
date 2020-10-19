package dfs.traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode51 {
    List<String[]> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        dfs(new boolean[n], new boolean[2 * n], new boolean[2 * n], 0, n, new String[n]);
        return res.stream().map(Arrays::asList).collect(Collectors.toList());
    }

    private void dfs(boolean[] col, boolean[] d1, boolean[] d2, int r, int n, String[] rows) {
        if (r == n) {
            for (int i = 0 ; i < n; i++) 
            return;
        }
        for (int i = 0; i < n; i++) {
            int diag1 = r - i + 2 * n, diag2 = r + i;
            if (!col[i] && !d1[diag1] && !d2[diag2]) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[i] = 'Q';
                rows[r] = new String(row);
                col[i] = true;
                d1[diag1] = true;
                d2[diag2] = true;
                dfs(col, d1, d2, r + 1, n, rows);
                col[i] = false;
                d1[diag1] = false;
                d2[diag2] = false;
            }
        }
    }
}
