/**
 * 扫雷游戏
 */
public class Leetcode529MineSweeper {

    int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'M') {
            return;
        }
        int count = 0;
        for (int[] dir : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (!(x >= 0 && y >= 0 && x < board.length && y < board[0].length)) {
                continue;
            }
            if (board[x][y] == 'M') {
                count++;
            }
        }
        if (count > 0) {
            board[i][j] = (char) (count + '0');
        } else {
            board[i][j] = 'B';
            for (int[] move : directions) {
                int x = move[0] + i;
                int y = move[1] + j;
                if (!(x >= 0 && y >= 0 && x < board.length && y < board[0].length)) {
                    continue;
                }
                if (board[x][y] == 'E') {
                    dfs(board, x, y);
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] input = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        Leetcode529MineSweeper leetcode529MineSweeper = new Leetcode529MineSweeper();
        leetcode529MineSweeper.updateBoard(input, new int[]{0, 0});
        System.out.println();
    }
}
