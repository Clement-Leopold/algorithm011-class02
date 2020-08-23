import java.util.Arrays;

public class Leetcode91 {

    public int numDecodingsDivide(String s) {
        int[] mem = new int[s.length() + 1];
        Arrays.fill(mem, -1);
        mem[s.length()] = 1;
        return s.length() == 0 ? 0 : decodings(s, 0, mem);
    }

    // divide and Conquer
    private int decodings(String s, int i, int[] mem) {
        if (mem[i] > -1) return mem[i];
        if (s.charAt(i) == '0') return mem[i] = 0;
        mem[i] = decodings(s, i + 1, mem);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
            mem[i] += decodings(s, i + 2, mem);
        return mem[i];
    }

    public int numDecodings(String s) {
        return s.length() == 0 ? 0 : decodings(s);
    }

    // dp
    private int decodings(String s) {
        int f1 = 1, f2 = 0;
        for (int j = s.length() - 1; j > -1; j--) {
            int cur = s.charAt(j) == '0' ? 0 : f1;
            if (j + 1 < s.length() && (s.charAt(j) == '1' || s.charAt(j) == '2' && s.charAt(j + 1) < '7')) {
                cur += f2;
            }
            f2 = f1;
            f1 = cur;
        }
        return f1;
    }

    public static void main(String[] args) {
        String s = "12";
        Leetcode91 leetcode91 = new Leetcode91();
        System.out.println(leetcode91.numDecodings(s));
    }

}
