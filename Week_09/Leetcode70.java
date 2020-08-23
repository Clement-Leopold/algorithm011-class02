public class Leetcode70 {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public int climbStairsOptimizeSpace(int n) {
        int f1 = 2, f2 = 1;
        for (int i = 3; i < n + 1; i++) {
            int temp = f1;
            f1 = f1 + f2;
            f2 = temp;
        }
        return f1;
    }
}
