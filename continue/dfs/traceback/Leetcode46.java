package dfs.traceback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) input.add(nums[i]);
        dfs(res, input, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> input, int i) {
        if (i == input.size()) res.add(new ArrayList<>(input));
        for (int j = i; j < input.size(); j++) {
            Collections.swap(input, j, i);
            dfs(res, input, i + 1);
            Collections.swap(input, j, i);
        }
    }
}
