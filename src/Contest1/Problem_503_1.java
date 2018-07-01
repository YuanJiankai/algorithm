package Contest1;

/**
 * Problem_503_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/30
 * @since 1.8 or after
 */
public class Problem_503_1 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = searchBig(nums, i);
        }
        return result;
    }

    public int searchBig(int[] nums, int index) {
        int len = nums.length;
        int i = index == len - 1 ? 0 : index + 1;
        while(i != index) {
            if(nums[i] > nums[index]) {
                return nums[i];
            }
            if(i == len - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        return -1;
    }
}
