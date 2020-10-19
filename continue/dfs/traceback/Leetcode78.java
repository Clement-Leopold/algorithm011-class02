package dfs.traceback;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        sub(nums, 0, new ArrayList<>());
        return res;
    }

    private void sub(int[] nums, int i, List<Integer> result) {
        res.add(new ArrayList<>(result));
        for (int j = i; j < nums.length; j++) {
            result.add(nums[j]);
            sub(nums, j + 1, result);
            result.remove(result.size() - 1);
        }
    }
}
