package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_18_1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            int x = nums[i];
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(x + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int p = j + 1;
                int q = nums.length - 1;
                while(p < q) {
                    int sum = nums[p] + nums[q] + nums[j];
                    if(x + sum == target) {
                        list.add(Arrays.asList(x, nums[p], nums[q], nums[j]));
                        while(p < q) {
                            if (nums[p] == nums[p + 1]) {
                                p++;
                            } else {
                                break;
                            }
                        }
                        while(p < q) {
                            if (nums[q] == nums[q - 1]) {
                                q--;
                            } else {
                                break;
                            }
                        }
                    }

                    if(x + sum == target) {
                        q--;
                        p++;
                    } else if(x + sum < target) {
                        p++;
                    } else {
                        q--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_18_1().fourSum(new int[]{0,0,0,0}, 0));
    }
}
