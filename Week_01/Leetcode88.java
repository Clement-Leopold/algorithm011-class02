public class Leetcode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last1 = m - 1;
        int last2 = n - 1;
        int index = nums1.length - 1;
        while (last1 > -1 && last2 > -1) nums1[index--] = nums1[last1] > nums2[last2] ? nums1[last1--] : nums2[last2--];
        while (last2 > -1) nums1[index--] = nums2[last2--];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        Leetcode88 leetcode88 = new Leetcode88();
        leetcode88.merge(nums1, 3, nums2, 3);
    }
}
