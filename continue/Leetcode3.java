import java.util.HashMap;

public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0, left = 0;
        int[] cache = new int[256];
        for (int right = 0; right < s.length(); right++) {
            left = cache[s.charAt(right)] > 0 ? Math.max(cache[s.charAt(right)], left) : left;
            cache[s.charAt(right)] = right + 1;
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstringUsingMap(String s) {
        int res = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            left = Math.max(left, map.getOrDefault(s.charAt(right), left));
            map.put(s.charAt(right), right + 1);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
