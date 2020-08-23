
public class Leetcode746 {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public static void main(String[] args) {
        int[] input = new int[]{10,15,20};
        Leetcode746 leetcode746 = new Leetcode746();
        leetcode746.minCostClimbingStairs(input);
    }
}
