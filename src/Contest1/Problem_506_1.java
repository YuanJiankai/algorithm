package Contest1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem_506_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/30
 * @since 1.8 or after
 */
public class Problem_506_1 {
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new String[0];
        }
        int len = nums.length;
        RankVo[] rv = new RankVo[len];
        for (int i = 0; i < len; i++) {
            RankVo r = new RankVo();
            r.index = i;
            r.score = nums[i];
            rv[i] = r;
        }
        Arrays.sort(rv);
        Map<Integer, String> rank = new HashMap<>();
        int i = 1;
        for(RankVo r : rv) {
            rank.put(r.index, i == 1 ? "Gold Medal" : i == 2 ? "Silver Medal" : i == 3 ? "Bronze Medal" : String.valueOf(i));
            i++;
        }
        String[] result = new String[len];
        for(int j = 0; j < len; j++) {
            result[j] = rank.get(Integer.valueOf(j));
        }
        return result;
    }
    class RankVo implements Comparable<RankVo> {
        int index;
        int score;

        @Override
        public int compareTo(RankVo o) {
            return o.score - this.score;
        }
    }
    @Test
    public void test() {
        String result[] = findRelativeRanks(new int[]{1,3,4,2});
        for(String i : result) {
            System.out.print(i + " ");
        }
    }
}
