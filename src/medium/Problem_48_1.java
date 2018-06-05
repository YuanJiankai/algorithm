package medium;

import org.junit.Test;

/**
 * Problem_48_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/3
 * @since 1.8 or after
 */
public class Problem_48_1 {
    public void rotate(int[][] matrix) {
        if (matrix != null && matrix.length != 1) {
            int len = matrix.length;
            for (int j = 0; j < len / 2; j++) {
                int start = j;
                int end = len - j - 1;
                for (int i = start; i < end; i++) {
                    int x = start;
                    int y = i;
                    int t = matrix[x][y];
                    while (true) {
                        if (x == start) {
                            x = y;
                            y = end;
                        } else if (x == end) {
                            x = y;
                            y = start;
                        } else {
                            int xtemp = x;
                            x = y;
                            y = len - xtemp - 1;
                        }
                        int temp = matrix[x][y];
                        matrix[x][y] = t;
                        t = temp;
                        if (x == start && y == i) {
                            break;
                        }
                    }
                }
            }
        }
    }

    @Test
    public void test() {
        int[][] n = new int[][]{{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
        rotate(n);
        for (int[] nums : n) {
            for (int i = 0, len = nums.length; i < len; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }
}
