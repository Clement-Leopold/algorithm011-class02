package dfs.traceback;

import java.util.*;

public class Leetcode47 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> arrays = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) arrays.add(nums[i]);
        dfs(arrays, 0);
        return res;
    }

    private void dfs(List<Integer> nums, int i) {
        if (i == nums.size()) res.add(new ArrayList<>(nums));
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < nums.size(); j++) {
            if (set.add(nums.get(j))) {
                Collections.swap(nums, i, j);
                dfs(nums, i + 1);
                Collections.swap(nums, i, j);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode47 leetcode47 = new Leetcode47();
        leetcode47.permuteUnique(new int[]{1, 1, 2});
    }

}
