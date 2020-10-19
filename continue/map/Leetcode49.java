package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s : strs) {
            char[] chars = new char[26];
            for (int i = 0; i < s.length(); i++) chars[s.charAt(i) - 'a']++;
            String aux = String.valueOf(chars);
            List<String> list = map.getOrDefault(aux, new ArrayList<>());
            list.add(s);
            map.putIfAbsent(aux, list);
        }
        map.forEach((k, v) -> res.add(v));
        return res;
    }

    public static void main(String[] args) {
        Leetcode49 leetcode49 = new Leetcode49();
        leetcode49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
