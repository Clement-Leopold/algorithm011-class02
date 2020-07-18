/**
 * 跳跃游戏
 */
public class Leetcode55JumpGame {

    public boolean canJump(int[] nums) {
        int furtheset = nums.length - 1;
        for (int i = nums.length - 1; i > -1; i--) {
            if (nums[i] + i >= furtheset) {
                furtheset = i;
            }
        }
        return furtheset == 0;
    }
}
