import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.Arrays;

/**
 * 打家劫舍
 */
public class Leetcode198 {

    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums.length == 1 ? nums[0] : 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int res = dp[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public int robDivide(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums, 0, dp);
    }

    private int rob(int[] nums, int i, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int thisTurn = rob(nums, i + 2, dp) + nums[i];
        int nextTurn = rob(nums, i + 1, dp);
        dp[i] = Math.max(thisTurn, nextTurn);
        return dp[i];
    }

    public static void main(String[] args) {
        Leetcode198 leetcode198 = new Leetcode198();
        System.out.println(leetcode198.robDivide(new int[]{}));
    }
}
