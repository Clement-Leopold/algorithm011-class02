import java.util.HashMap;
import java.util.Map;

public class Leetcode387 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = init(s);
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    private Map<Character, Integer> init(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, (v1, v2) -> v1 + v2);
        }
        return map;
    }
}
