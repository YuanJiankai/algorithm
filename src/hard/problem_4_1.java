package hard;

/**
 * 这个是4问题的极其复杂的解法, 但是思路还是比较正确的就是少了一些地方
 */
public class problem_4_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return nums1.length == 0 ? findMedianByOneArray(nums2) : findMedianByOneArray(nums1);
        }
        int is1 = nums1.length / 2;
        int ig1 = is1 + 1;
        int ig2 = nums2.length / 2;
        int is2 = ig2 - 1;
        int max = max(nums1, nums2, is1, is2);
        int min = min(nums1, nums2, ig1, ig2);
        while ((min(nums1, nums2, ig1, ig2) == 1 ? nums1[ig1] : nums2[ig2]) < (max(nums1, nums2, is1, is2) == 1 ? nums1[is1] : nums2[is2])) { // !!!!!!这里出现数组越界 由于边界问题
            if (max == 1) { // 移动操作
                is1--;
                ig1++;
            } else {
                is2--;
                ig2++;
            }
            if (min == 1) {
                ig1++;
                is1--;
            } else {
                ig2++;
                is2--;
            }
            max = max(nums1, nums2, is1, is2);
            min = min(nums1, nums2, ig1, ig2);
        }

        // 修正操作
        int sizes = is1 + is2 + 2;
        int sizeg = nums1.length + nums2.length - sizes;
        max = max(nums1, nums2, is1, is2);
        min = min(nums1, nums2, ig1, ig2);
        int a = 0;
        while ((a = Math.abs(sizes - sizeg)) > 1) {
            if (sizes > sizeg) {
                if (max == 1) {
                    is1--;
                } else {
                    is2--;
                }
            } else {
                if (min == 1) {
                    ig1++;
                } else {
                    ig2++;
                }
            }
            max(nums1, nums2, is1, is2);
            min(nums1, nums2, ig1, ig2);
        }
        // 最后求中位数
        if (a == 1) {
            if (sizes > sizeg) {
                if (max == 1) {
                    return (double) nums1[is1];
                } else {
                    return (double) nums2[is2];
                }
            } else {
                if (min == 1) {
                    return (double) nums1[ig1];
                } else {
                    return (double) nums2[ig2];
                }
            }
        } else {
            return (double) ((max == 1 ? nums1[is1] : nums2[is2]) + (min == 1 ? nums1[ig1] : nums2[ig2])) / 2.0;
        }
    }

    public double findMedianByOneArray(int[] nums) {
        if (nums.length % 2 == 0) {
            return (double) (nums[nums.length / 2] + nums[nums.length / 2 + 1]) / 2.0;
        } else {
            return (double) nums[nums.length / 2];
        }
    }

    public int max(int nums1[], int nums2[], int indexs1, int indexs2) { // 返回值1: 最大值在第一个数组, 2: 最大值在第二个数组
        if (indexs1 < 0) {
            return 2;
        }
        if (indexs2 < 0) {
            return 1;
        }
        return nums1[indexs1] > nums2[indexs2] ? 1 : 2;
    }

    public int min(int nums1[], int nums2[], int indexb1, int indexb2) { // 返回值1: 最小值在第一个数组, 2: 最小值在第二个数组
        if (indexb1 >= nums1.length) {
            return 2;
        }
        if (indexb2 >= nums2.length) {
            return 1;
        }
        return nums1[indexb1] > nums2[indexb2] ? 2 : 1;
    }

    public static void main(String[] args) {
        System.out.println(new problem_4_1().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
