import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int i, int j, Trie root, String s) {
        if (i > board.length - 1 || i < 0 || j > board[0].length - 1 || j < 0) {
            return;
        }
        if (board[i][j] == '#' || null == (root = searchChar(root, board[i][j]))) {
            return;
        }
        char temp = board[i][j];
        s = s + temp;
        board[i][j] = '#';
        if (root.word != null) {
            res.add(s);
        }
        for (int[] dir : dirs) {
            dfs(board, i + dir[0], j + dir[1], root, s);
        }
        board[i][j] = temp;
    }

    class Trie {
        Trie[] next = new Trie[26];
        String word;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie head = root;
            for (char c : word.toCharArray()) {
                Trie trie = head.next[c - 'a'];
                if (trie == null) {
                    trie = new Trie();
                    head.next[c - 'a'] = trie;
                }
                head = trie;
            }
            head.word = word;
        }
        return root;
    }

    private Trie searchChar(Trie root, char c) {
        Trie trie = root.next[c - 'a'];
        if (trie == null) {
            return null;
        }
        return trie;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        char[][] array = new char[][]{

                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        WordSearchII wordSearchII = new WordSearchII();
        wordSearchII.findWords(array, words);
        System.out.println();
    }
}
