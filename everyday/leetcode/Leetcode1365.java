package leetcode;

public class Leetcode1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101]; int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i < 101; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {8,1,2,2,3};
        Leetcode1365 leetcode1365 = new Leetcode1365();
        leetcode1365.smallerNumbersThanCurrent(nums);
    }

}
