package greed;

public class Leetcode55 {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (max >= i) {
                max = Math.max(max, i + nums[i]);
            }
        }
        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 3};
        Leetcode55 leetcode55 = new Leetcode55();
        System.out.println(leetcode55.canJump(nums));
    }

}
