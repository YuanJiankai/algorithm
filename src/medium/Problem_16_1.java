package medium;

import java.util.Arrays;

public class Problem_16_1 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return -1;
        }
        int t = 0;
        int c = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int p = i + 1;
            int q = length - 1;
            while (p < q) {
                int x = nums[p] + nums[q] + nums[i];
                int abs = Math.abs(target - x);
                if(c > abs) {
                    c = abs;
                    t = x;
                }
                if (x == target) {
                    return target;
                } else if (x > target) {
                    q--;
                } else {
                    p++;
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_16_1().threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
    }
}
