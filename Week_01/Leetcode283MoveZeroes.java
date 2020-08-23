public class Leetcode283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 2, 3};
        Leetcode283MoveZeroes leetcode283MoveZeroes = new Leetcode283MoveZeroes();
        leetcode283MoveZeroes.moveZeroes(nums);
        System.out.println();
    }
}
