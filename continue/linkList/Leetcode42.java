package linkList;

import java.util.LinkedList;

public class Leetcode42 {

    public int trap(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int bottom = stack.poll();
                if (!stack.isEmpty()) {
                    int width = i - stack.peek() - 1;
                    res += width * (Math.min(height[stack.peek()], height[i]) - height[bottom]);
                }
            }
            stack.push(i);
        }
        return res;
    }
}
