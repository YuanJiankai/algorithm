package medium;

import java.util.Arrays;

public class Problem_31_1 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int nums2[] = new int[len];
        int i = len - 1, j = -1; // 设置两个标志 一个是head 一个是tail 其实就是标志两个需要换位的数字
        for(int k = len - 1; k > 0; k--) {
            if(nums[k] > nums[k - 1]) {
                j = k - 1;
                break;
            }
        }
        if(j == -1) {
//            int l = len - 1;
////            for(int k = 0; k < len; k++) {
////                nums2[k] = nums[l--];
////            }
            Arrays.sort(nums);
        } else {
            int m = nums[j];
            for(int k = j + 1; k < len; k++) {
                if(nums[k] <= m) {
                    i = k - 1;
                    break;
                }
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            Arrays.sort(nums, j + 1, len);
//            // 构建nums2数组
//            int index = 0;
//            for(int k = 0; k < j; k++) {
//                nums2[index++] = nums[k];
//            }
//            nums2[index++] = nums[i];
//            for(int k = len - 1; k > i; k--) {
//                nums2[index++] = nums[k];
//            }
//            nums2[index++] = nums[j];
//            for(int k = i - 1; k > j; k--) {
//                nums2[index++] = nums[k];
//            }
        }
//        copy(nums2, nums);
    }
    public void copy(int[] source, int[] target) {
        int len = source.length;
        for(int i = 0; i < len; i++) {
            target[i] = source[i];
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1};
        new Problem_31_1().nextPermutation(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
