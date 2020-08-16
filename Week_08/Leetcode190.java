public class Leetcode190 {

    public int reverseBits(int n) {
        int ret = 0;
        int power = 32;
        while (n != 0) {
            ret += (n & 1) << (power--);
            n >>= 1;
        }
        return ret;
    }
}
