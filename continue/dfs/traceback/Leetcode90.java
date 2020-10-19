package dfs.traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> result) {
        res.add(new ArrayList<>(result));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j - 1] == nums[j]) continue;
            result.add(nums[j]);
            dfs(nums, j + 1, result);
            result.remove(result.size() - 1);
        }
    }
}
