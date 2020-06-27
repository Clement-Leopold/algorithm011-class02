/**
 * 删除重复项,不使用数组空间，原地修改
 */
public class Leetcode26 {
    public static int removeDuplicates(int[] nums) {
        int index = nums.length == 0 ? 0 : 1;
        for (int n : nums) {
            if (n > nums[index - 1]) {
                nums[index++] = n;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 1,1,1,1,3};
        removeDuplicates(array);
    }
}

