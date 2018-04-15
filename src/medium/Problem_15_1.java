package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_15_1 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int p = i + 1;
            int q = length - 1;
            while (p < q) {
                if (nums[p] + nums[q] == -nums[i]) {
                    list.add(Arrays.asList(nums[p], nums[q], nums[i]));
                    while (p < q) {
                        q--;
                        if (nums[q] != nums[q + 1]) {
                            break;
                        }
                    }
                    while (p < q) {
                        p++;
                        if (nums[p] != nums[p - 1]) {
                            break;
                        }
                    }
                } else if (nums[p] + nums[q] > -nums[i]) {
                    q--;
                } else {
                    p++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_15_1().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
