package medium;

import org.junit.Test;

/**
 * Problem_55_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/14
 * @since 1.8 or after
 */
public class Problem_55_1 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return false;
        }
        int index = 0;
        while(index < len - 1) {
            int i = findZero(nums, index, len - 1);
            if(i == -1) {
                return true;
            }
            if(i == index) {
                return false;
            }
            int sum = 1;
            for(int j = i + 1; j < len; j++) {
                if(nums[j] != 0) {
                    break;
                }
                sum++;
            }
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] + j == len - 1) {
                    return true;
                }
                if(nums[j] + j >= i + sum) {
                    index = i + sum;
                    break;
                }
                if(j == 0) {
                    return false;
                }
            }

        }
        return true;
    }
    public int findZero(int[] nums, int start, int end) {
        for(int i = start; i < end; i++) {
            if(nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(canJump(new int[]{2, 0, 0}));
    }
}
