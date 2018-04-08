package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这是一种解决问题的方式 回溯法 40题 只需要做简单修改(回溯法的简单应用, 这个是数字组合问题)
 */
public class Problem_39_1 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);
        if (target < 0) {
            return resultList;
        }
        backMethod(candidates, tempList, resultList, target, 0);
        return resultList;
    }

    public void backMethod(int[] candidates, List<Integer> tempList, List<List<Integer>> resultList, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            resultList.add(new ArrayList<>(tempList));
        } else {
            int remove = 0;
            for (int i = start, len = candidates.length; i < len && remain >= candidates[i]; i++) {
                if(candidates[i] == remove) continue;
                tempList.add(candidates[i]);
                backMethod(candidates, tempList, resultList, remain - candidates[i], i + 1);
                remove = tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem_39_1().combinationSum2(new int[]{2, 2, 2}, 4).toString());
    }
}
