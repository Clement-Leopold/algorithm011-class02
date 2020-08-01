public class Leetcode91DecodeWays {

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] ways = new int[s.length() + 1];
        ways[0] = 1;
        ways[1] = s.charAt(0) > '0' ? 1 : 0;
        for (int i = 2; i < ways.length; i++) {
            int first = s.charAt(i - 2) - '0';
            int second = s.charAt(i - 1) - '0';
            if (first == 1 || (first == 2 && second <= 6)) {
                ways[i] += ways[i - 2];
            }
            if (second > 0) {
                ways[i] += ways[i - 1];
            }
        }
        return ways[ways.length - 1];
    }

    public static void main(String[] args) {
        String s = "1001";
        Leetcode91DecodeWays leetcode91DecodeWays = new Leetcode91DecodeWays();
        System.out.println(leetcode91DecodeWays.numDecodings(s));
    }
}
