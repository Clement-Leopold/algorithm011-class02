import java.util.*;

/**
 * 全排列
 */
public class Leetcode46Permute {

    List<List<Integer>> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return list;
        }
        permuteRecur(nums, 0, new ArrayList<>());
        return list;
    }

    private void permuteRecur(int[] nums, int i, List<Integer> result) {

        if (result.size() == nums.length) {
            list.add(new ArrayList<>(result));
            return;
        }

        for (int k = 0; k < nums.length; k++) {
            if (set.contains(k)) {
                continue;
            }
            result.add(nums[k]);
            set.add(k);
            permuteRecur(nums, k, result);
            set.remove(k);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode46Permute leetcode46Permute = new Leetcode46Permute();
        leetcode46Permute.permute(new int[]{1, 2, 3});
    }
}
