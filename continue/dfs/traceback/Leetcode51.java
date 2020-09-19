package dfs.traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode51 {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        boolean[] c = new boolean[n];
        LinkedList<String> board = new LinkedList<>();
        dfs(d1, d2, c, res, 0, board, n);
        return res;
    }

    private void dfs(boolean[] d1, boolean[] d2, boolean[] c, List<List<String>> res, int r, LinkedList<String> board, int n) {
        if (n == r) {
            res.add(new ArrayList<>(board));
        } else {
            for (int col = 0; col < n; col++) {
                int diag1 = r - col + n, diag2 = r + col;
                if (d1[diag1] || d2[diag2] || c[col]) continue;
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[col] = 'Q';
                board.addLast(new String(chars));
                d1[diag1] = true;
                d2[diag2] = true;
                c[col] = true;
                dfs(d1, d2, c, res, r + 1, board, n);
                d1[diag1] = false;
                d2[diag2] = false;
                c[col] = false;
                board.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        Leetcode51 leetcode51 = new Leetcode51();
        leetcode51.solveNQueens(4);
    }
}
