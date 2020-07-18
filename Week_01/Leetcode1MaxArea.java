public class Leetcode1MaxArea {

    public int maxArea(int[] height) {
        int max = 0;
        if (height.length == 0) {
            return max;
        }
        int i = 0, j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[j], height[i]) * (j - i);
            max = Math.max(area, max);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
