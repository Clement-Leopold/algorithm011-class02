import java.util.Arrays;

/**
 * 打家劫舍
 */
public class Leetcode213HouseRobber {

    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums.length == 1 ? nums[0] : 0;
        }
        int[] input1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] input2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(robSub(input1), robSub(input2));
    }

    private int robSub(int[] nums) {
        if (nums.length == 1) {
            return nums.length == 1 ? nums[0] : 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        dp = null;
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2};
        Leetcode213HouseRobber leetcode213HouseRobber = new Leetcode213HouseRobber();
        leetcode213HouseRobber.rob(array);
    }

}
