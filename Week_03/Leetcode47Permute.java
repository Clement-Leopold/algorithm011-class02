import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 全排列-包含重复数值
 */
public class Leetcode47Permute {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return list;
        }
        List<Integer> numsList = IntStream.of(nums).boxed().collect(Collectors.toList());
        permuteRecur(numsList, 0);
        return list;
    }

    private void permuteRecur(List<Integer> nums, int i) {
        if (i == nums.size()) {
            list.add(new ArrayList<>(nums));
        }
        Set<Integer> set = new HashSet<>();
        for (int po = i; po < nums.size(); po++) {
            if (set.add(nums.get(po))) {
                Collections.swap(nums, i, po);
                permuteRecur(nums, po + 1);
                Collections.swap(nums, i, po);
            }
        }
    }


    public static void main(String[] args) {
        Leetcode47Permute leetcode46Permute = new Leetcode47Permute();
        leetcode46Permute.permuteUnique(new int[]{1, 1, 3});
    }
}
