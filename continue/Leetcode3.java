import dfs.traceback.Leetcode51;

import java.util.HashMap;

public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, res = 0;
        int[] array = new int[256];
        for (int right = 0; right < s.length(); right++) {
            if (array[s.charAt(right)] > 0) left = Math.max(left, array[s.charAt(right)]);
            array[s.charAt(right)] = right + 1;
            res = Math.max(right - left + 1, res);
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

    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        leetcode3.lengthOfLongestSubstring("abcabcbbac");
    }
}
