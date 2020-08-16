public class Leetcode912 {

    public int[] quickSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }


    private void quicksort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = start, i = start + 1, j = end;
        while (i <= j) {
            while (i <= j && nums[i] <= nums[pivot]) i++;
            while (i <= j && nums[j] >= nums[pivot]) j--;
            if (i > j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int temp = nums[j];
        nums[j] = nums[pivot];
        nums[pivot] = temp;
        quicksort(nums, start, j - 1);
        quicksort(nums, j + 1, end);
    }

    public int[] mergeSort(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergesort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        mergesort(nums, start, mid);
        mergesort(nums, mid + 1, end);
        int i = start, j = mid + 1, index = 0;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) temp[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        while (i <= mid) temp[index++] = nums[i++];
        while (j <= end) temp[index++] = nums[j++];
        System.arraycopy(temp, 0, nums, start, end - start + 1);
    }


    public static void main(String[] args) {
        int[] arrays = new int[]{2, 1, 2, 5, 3};
        Leetcode912 leetcode912 = new Leetcode912();
        leetcode912.mergeSort(arrays);
        System.out.printf("");
    }

}
