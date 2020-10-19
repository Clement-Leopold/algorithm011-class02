package dfs.traceback;

import java.util.*;
import java.util.stream.IntStream;

public class Leetcode47 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return res;
        Arrays.sort(nums);
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) input.add(nums[i]);
        helper(input, 0);
        return res;
    }

    private void helper(List<Integer> nums, int i) {
        if (i == nums.size()) res.add(new ArrayList<>(nums));
        else {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < nums.size(); j++) {
                if (set.add(nums.get(j))) {
                    Collections.swap(nums, i, j);
                    helper(nums, i + 1);
                    Collections.swap(nums, i, j);
                }
            }
        }
    }
}
