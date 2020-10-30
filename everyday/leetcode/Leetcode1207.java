package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (i < arr.length - 1 && arr[i + 1] != arr[i]) {
                if (!set.add(count)) return false;
                count = 1;
            } else count++;
        }
        return set.add(count);
    }
}
