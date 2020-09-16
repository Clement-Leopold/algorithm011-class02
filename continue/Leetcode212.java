import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode212 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        init(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, set, root);
            }
        }
        res.addAll(set);
        return res;
    }

    int[][] dics = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private void dfs(char[][] board, int row, int col, Set<String> res, Node cur) {
        if (row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1) return;
        if (board[row][col] == '0') return;
        Node node = cur.nodes[board[row][col] - 'a'];
        if (node == null) return;
        if (node.word != null) {
            res.add(node.word);
        }
        char c = board[row][col];
        board[row][col] = '0';
        for (int[] dic : dics) dfs(board, row + dic[0], col + dic[1], res, node);
        board[row][col] = c;
    }

    private Node root = new Node();

    private void init(String[] words) {
        for (String word : words) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (cur.nodes[word.charAt(i) - 'a'] == null) {
                    cur.nodes[word.charAt(i) - 'a'] = new Node();
                }
                cur = cur.nodes[word.charAt(i) - 'a'];
            }
            cur.word = word;
        }
    }

    private class Node {
        Node[] nodes = new Node[26];
        String word;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'a', 'b'}, {'a', 'a'}};
        String[] words = new String[]{"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"};
        Leetcode212 leetcode212 = new Leetcode212();
        leetcode212.findWords(chars, words);
    }
}

