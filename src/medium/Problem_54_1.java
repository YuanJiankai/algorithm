package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem_54_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/5
 * @since 1.8 or after
 */
public class Problem_54_1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int len = 0;
        if (matrix == null || (len = matrix.length) == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int rstart = 0;
        int rend = matrix[0].length - 1;
        int cstart = 0;
        int cend = len - 1;
        int flag = 0;
        while (rstart <= rend && cstart <= cend) {
            if (flag == 0) {
                for (int i = rstart; i <= rend; i++) {
                    result.add(matrix[cstart][i]);
                }
                cstart++;
                flag = 1;
            } else if (flag == 1) {
                for (int i = cstart; i <= cend; i++) {
                    result.add(matrix[i][rend]);
                }
                rend--;
                flag = 2;
            } else if (flag == 2) {
                for(int i = rend; i >= rstart; i--) {
                    result.add(matrix[cend][i]);
                }
                cend--;
                flag = 3;
            } else {
                for(int i = cend; i >= cstart; i--) {
                    result.add(matrix[i][rstart]);
                }
                rstart++;
                flag = 0;
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(spiralOrder(new int[][]{{1,2,3,10}, {4,5,6,11}, {7,8,9,12}}));
//        System.out.println(spiralOrder(new int[][]{{1}, {2}}));
    }
}