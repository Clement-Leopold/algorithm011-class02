import javax.rmi.CORBA.Tie;

public class Trie {

    private TrieNode root;

    private class TrieNode {
        private TrieNode[] next;
        private String word;

        TrieNode() {
            next = new TrieNode[26];
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode head = root;
        for (char c : word.toCharArray()) {
            TrieNode trie = head.next[c - 'a'];
            if (trie == null) {
                head.next[c - 'a'] = new TrieNode();
                trie = head.next[c - 'a'];
            }
            head = trie;
        }
        head.word = word;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode head = root;
        for (char c : word.toCharArray()) {
            TrieNode trie = head.next[c - 'a'];
            if (trie == null) {
                return false;
            }
            if (word.equals(trie.word)) {
                return true;
            }
            head = trie;
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode head = root;
        for (char c : prefix.toCharArray()) {
            TrieNode trie = head.next[c - 'a'];
            if (trie == null) {
                return false;
            }
            head = trie;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println();
    }
}
