package linkList;

import java.util.LinkedList;

public class Leetcode84 {

    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        int[] aux = new int[heights.length + 2];
        System.arraycopy(heights, 0, aux, 1, heights.length);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < aux.length; i++) {
            int size = 0;
            while (aux[stack.peekLast()] > aux[i]) {
                size = aux[stack.pollLast()] * (i - stack.peekLast() - 1);
                res = Math.max(res, size);
            }
            stack.addLast(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 5, 6, 2, 3};
        Leetcode84 leetcode84 = new Leetcode84();
        leetcode84.largestRectangleArea(input);
    }
}
