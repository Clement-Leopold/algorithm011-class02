import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Offer49UglyNumber {

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        int[] ans = new int[n];
        queue.add(1L);
        seen.add(1L);
        int[] factor = {2, 3, 5};
        for (int i = 0; i < ans.length; i++) {
            long temp = queue.poll();
            ans[i] = (int)temp;
            for (int fac : factor) {
                long value = temp * fac;
                if (!seen.contains(value)) {
                    queue.add(value);
                    seen.add(value);
                }
            }
        }
        return ans[n - 1];
    }

    public static void main(String[] args) {
        Offer49UglyNumber offer49UglyNumber = new Offer49UglyNumber();
        offer49UglyNumber.nthUglyNumber(1407);
    }

}
