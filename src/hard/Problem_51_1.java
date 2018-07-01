package hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem_51_1.java
 * Description: a N-Queens problem 回溯法 经典应用 这个题目的核心是学会非递归版本的回溯法
 *
 * @author v_yuanjiankai
 * @date 2018/6/5
 * @since 1.8 or after
 */
public class Problem_51_1 {
    /**
     * 一开始没有搞懂 现在知道了怎么用一维数组表示地图
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        Map<Integer, Integer> reachMap = new HashMap<>(); // 可达性Map 存储的是横纵坐标绝对值, 绝对值不同的自然也就不再一条斜线上
        int[] abMap = new int[n]; // 抽象地图
        int[] remark = new int[n]; // 标记列时候可用
        List<List<String>> result = new ArrayList<>();
        backMethod(reachMap, abMap, result, 0, remark);
        return result;
    }

    public void backMethod(Map<Integer, Integer> reachMap, int[] abMap, List<List<String>> result, int line, int[] remark) {
        if (line == abMap.length) {
            result.add(createMap(abMap));
            return;
        }
        for (int i = 0, len = abMap.length; i < len; i++) {
            int abs = i - line; // 这个代表的是k = -1 斜线与y轴交点 代表了其唯一性
            int sum = i + line; // 这个代表的是k = 1 斜线与y轴交点, 代表了斜线唯一性
            if (remark[i] == 0 && !reachMap.containsValue(sum) && !reachMap.containsKey(abs)) {
                abMap[line] = i;
                remark[i] = 1;
                reachMap.put(abs, sum);
                backMethod(reachMap, abMap, result, line + 1, remark);
                remark[i] = 0;
                reachMap.remove(abs);
            }
        }
        return;
    }

    public List<String> createMap(int[] abMap) {
        List<String> map = new ArrayList<>();
        int len = abMap.length;
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if (j == abMap[i]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            map.add(sb.toString());
        }
        return map;
    }

    /**
     * 这个是只计数
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        return backMethod2(new int[2 * n - 1], new int[2 * n - 1], 0, new int[n], n);
    }

    public int backMethod2(int[] b, int[] p, int line, int[] remark, int n) {
        int result = 0;
        if (line == n) {
            return 1;
        }
        for (int i = 0, len = n; i < len; i++) {
            int b1 = i - line + (n - 1); // 这个代表的是k = -1 斜线与y轴交点 代表了其唯一性 为了解决负数的情况 加一个(n - 1) 这样最小的负数是零
            int b2 = i + line; // 这个代表的是k = 1 斜线与y轴交点, 代表了斜线唯一性
            if (remark[i] == 0 && b[b1] == 0 && p[b2] == 0) {
                remark[i] = 1;
                b[b1] = 1;
                p[b2] = 1;
                result += backMethod2(b, p, line + 1, remark, n);
                remark[i] = 0;
                b[b1] = 0;
                p[b2] = 0;
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(totalNQueens(10));
    }
}
