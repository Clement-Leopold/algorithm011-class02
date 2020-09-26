package tree;

public class Leetcode130 {

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            recur(board, i, 0);
            recur(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            recur(board, 0, i);
            recur(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int[][] dics = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private void recur(char[][] board, int i, int j) {
        if ((i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != 'O')) {
            return;
        }
        board[i][j] = 'A';
        for (int[] dic : dics) {
            recur(board, i + dic[0], j + dic[1]);
        }
    }
}
