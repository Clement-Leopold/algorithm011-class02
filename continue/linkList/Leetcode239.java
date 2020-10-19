package linkList;

import java.util.LinkedList;

public class Leetcode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> window = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!window.isEmpty() && window.peek() < i - k + 1) window.poll();
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) window.pollLast();
            window.addLast(i);
            if (i >= k - 1) res[index++] = nums[window.peek()];
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode239 leetcode239 = new Leetcode239();
        int[] r = leetcode239.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
    }
}
