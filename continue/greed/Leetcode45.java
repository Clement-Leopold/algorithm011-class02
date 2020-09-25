package greed;

public class Leetcode45 {

    public int jump(int[] nums) {
        int max = 0, end = 0, step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(nums[i] + i, max);
            if (i == end) {
                step++;
                end = max;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Leetcode45 leetcode45 = new Leetcode45();
        leetcode45.jump(new int[]{2, 3, 1, 1, 4});
    }

}
