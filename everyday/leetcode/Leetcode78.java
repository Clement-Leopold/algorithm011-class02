package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, new ArrayList<>(), result, nums);
        return result;
    }

    private void dfs(int i, List<Integer> list, List<List<Integer>> result, int[] nums) {
        result.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            list.add(nums[i]);
            dfs(j + 1, list, result, nums);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Leetcode78 leetcode78 = new Leetcode78();
        leetcode78.subsets(nums);
    }
}
