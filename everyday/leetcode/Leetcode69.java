package leetcode;

public class Leetcode69 {

    public int mySqrt(int x) {
        long left = 0, right = x, ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else if (mid * mid > x) right = mid - 1;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Leetcode69 leetcode69 = new Leetcode69();
        leetcode69.mySqrt(8);
    }
}
