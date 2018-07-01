package Contest1;

import org.junit.Test;

import java.util.Arrays;

/**
 * Problem_496_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/30
 * @since 1.8 or after
 */
public class Problem_496_1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0) {
            return new int[0];
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1];
        for(int i = 0; i < len1; i++) {
            result[i] = -1;
            int index = 0;
            for(int j = 0; j < len2; j++) {
                if(nums2[j] == nums1[i]) {
                    index = j;
                }
            }
            for(int j = index + 1; j < len2; j++) {
                if(nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int result[] = nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
