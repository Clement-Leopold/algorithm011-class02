import java.util.Arrays;
import java.util.HashMap;

public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        int[] array = new int[256];
        int length = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (array[s.charAt(right)] > 0) {
                left = Math.max(left, array[s.charAt(right)]);
            }
            array[s.charAt(right)] = right + 1;
            length = Math.max(length, right - left + 1);
        }
        return length;
    }

    public int lengthOfLongest(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcaabbdef";
        Leetcode3 leetcode3 = new Leetcode3();
        leetcode3.lengthOfLongestSubstring(s);

    }
}

