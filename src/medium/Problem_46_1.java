package medium;

import org.junit.Test;

import java.util.*;

/**
 * Problem_46_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/5/31
 * @since 1.8 or after
 */
public class Problem_46_1 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        backMethod(new ArrayList<>(), nums, result, new int[nums.length], new HashMap<>());
        return result;


    }


    public void backMethod(List<Integer> list, int[] nums, List<List<Integer>> result, int[] flag, Map<String, Integer> remark) {
        if (nums.length == list.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0, len = nums.length; i < len; i++) {
            if(flag[i] == 0 && !remark.containsKey(String.valueOf(nums[i]))) {
                remark.put(String.valueOf(nums[i]), 1);
                flag[i] = 1;
                list.add(nums[i]);
                backMethod(list, nums, result, flag, new HashMap<>());
                flag[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        List<List<Integer>> list = permuteUnique(new int[]{1,1,3,3});
        for(List<Integer> l : list) {
            System.out.println(l.toString());
        }
    }
}
