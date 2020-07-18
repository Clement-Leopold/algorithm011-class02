/**
 * 搜索旋转数组
 */
public class Leetcode33SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int lo = 0, high = nums.length - 1;
        while (lo <= high) {
            int mid = (lo + high) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            // 如果左边有序
            if (nums[lo] <= nums[mid]) {
                //严格意义保证在左边
                if (nums[lo] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[high] >= target) {
                    lo = mid + 1;
                }else {
                    high = mid  -1;
                }
            }
        }
        return  -1;
    }
}
