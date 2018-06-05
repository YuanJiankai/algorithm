package hard;

public class Problem_45_1 {
    public int jump(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1) {
            return 0;
        }
        int count = 0;
        int index = 0;
        int max = nums[0];
        while(index != len) {
            if(max == 0) {
                return 0;
            }
            if(max + index >= len - 1) {
                return count + 1;
            } else {
                int result = findMax(nums, index, max);
                count++;
                index = result;
                max = nums[index];
            }
        }
        return count;
    }
    public int findMax(int[] nums, int start, int len) {
        int index = start + 1;
        for(int i = index + 1; i < Math.min(nums.length, len + start + 1); i++) {
            int cur = i - start;
            if(nums[i] + i >= nums[index] + index) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_45_1().jump(new int[]{2,3,1,1,4}));
    }
}
