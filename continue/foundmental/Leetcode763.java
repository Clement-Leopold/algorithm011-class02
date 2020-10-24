package foundmental;

import java.util.ArrayList;
import java.util.List;

public class Leetcode763 {

    public List<Integer> partitionLabels(String S) {
        int[] aux = new int[26];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            aux[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(aux[S.charAt(i)], end);
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}
