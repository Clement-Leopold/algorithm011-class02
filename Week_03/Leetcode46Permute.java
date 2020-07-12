import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 全排列
 */
public class Leetcode46Permute {


    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return list;
        }
        List<Integer> numList = IntStream.of(nums).boxed().collect(Collectors.toList());
        permuteRecur(numList, 0);
        return list;
    }

    private void permuteRecur(List<Integer> nums, int first) {
        if (first == nums.size()) {
            list.add(new ArrayList<>(nums));
            return;
        }
        for (int i = first; first < nums.size(); first++) {
            Collections.swap(nums, i, first);
            permuteRecur(nums, i + 1);
            Collections.swap(nums, i, first);
        }
    }

    public static void main(String[] args) {
        Leetcode46Permute leetcode46Permute = new Leetcode46Permute();
        List<List<Integer>> ans = leetcode46Permute.permute(new int[]{1, 2, 3});
        System.out.println();
    }
}
