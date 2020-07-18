import java.util.*;

/**
 * 单词接龙
 */
public class Leetcode127WordLadder {

    final HashMap<String, List<String>> map = new HashMap<>();
    final LinkedList<Pair> list = new LinkedList<>();
    final HashSet<String> visited = new HashSet<>();
    int wordLength;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordLength = beginWord.length();
        if (beginWord.equals(endWord)) {
            return 1;
        }
        init(wordList);
        visited.add(beginWord);
        list.add(new Pair(beginWord, 1));
        return bfs(endWord);
    }

    private void init(List<String> words) {
        for (String word : words) {
            for (int i = 0; i < wordLength; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> group = map.getOrDefault(newWord, new ArrayList<>());
                group.add(word);
                map.put(newWord, group);
            }
        }
    }

    private int bfs(String end) {
        while (!list.isEmpty()) {
            Pair pair = list.pollFirst();
            String word = pair.word;
            int level = pair.level;
            for (int i = 0; i < wordLength; i++) {
                String newword = word.substring(0, i) + "*" + word.substring(i + 1);
                for (String adj : map.getOrDefault(newword, new ArrayList<>())) {
                    if (adj.equals(end)) {
                        return level + 1;
                    }
                    if (visited.add(adj)) {
                        list.add(new Pair(adj, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    private class Pair {
        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }


    public static void main(String[] args) {
        Leetcode127WordLadder leetcode127WordLadder = new Leetcode127WordLadder();
        leetcode127WordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }
}

