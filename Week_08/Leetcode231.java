public class Leetcode231 {

    public boolean isPowerOfTwo(int n) {
        long x = (long) n;
        if (x == 0) {
            return false;
        }
        return (x & (x - 1)) == 0;
    }
}
