public class Leetcode191 {

    public int hammingWeight(int n) {
        int x = n;
        int count = 0;
        while (x != 0) {
            x = x & (x - 1);
            count++;
        }
        return count;
    }

    /**
     * 1010
     * 1001
     * @param args
     */
    public static void main(String[] args) {
        Leetcode191 leetcode191 = new Leetcode191();
        int x = leetcode191.hammingWeight(10);
        System.out.println(x);
    }
}
