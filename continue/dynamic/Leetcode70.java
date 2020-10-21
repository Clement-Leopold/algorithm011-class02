package dynamic;

public class Leetcode70 {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int p1 = 1, p2 = 2, res = 0;
        for (int i = 3; i < n + 1; i++)  {
            res = p1 + p2;
            p2 = p1;
            p1 = res;
        }
        return  res;
    }
}
