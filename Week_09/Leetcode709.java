import java.util.HashMap;
import java.util.Map;

public class Leetcode709 {

    public String toLowerCase(String str) {
        Map<Character, Character> map = init();
        StringBuilder res = new StringBuilder();
        for (char c : str.toCharArray()) {
            char x = map.getOrDefault(c, c);
            res.append(x);
        }
        return res.toString();
    }

    private Map<Character, Character> init() {
        HashMap<Character, Character> map = new HashMap<>();
        for (char c = 'A', v = 'a'; c <= 'Z' && v <= 'z'; c++, v++) {
            map.put(c, v);
        }
        return map;
    }
}
