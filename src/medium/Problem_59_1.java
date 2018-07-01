package medium;

import org.junit.Test;

/**
 * Problem_59_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/29
 * @since 1.8 or after
 */
public class Problem_59_1 {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return null;
        }
        int[][] result = new int[n][n];
        int index = 1;
        for (int i = 0, j = n - 1; i <= j; i++, j--) {
            int start = i;
            int end = j;
            if(start == end) {
                result[start][start] = n * n;
                break;
            }
            int flag = 0;
            while(true) {
                if(flag == 0) {
                    for(int k = start; k < end; k++) {
                        result[start][k] = index++;
                    }
                    flag = 1;
                } else if(flag == 1) {
                    for(int k = start; k < end; k++) {
                        result[k][end] = index++;
                    }
                    flag = 2;
                } else if(flag == 2) {
                    for(int k = end; k > start; k--) {
                        result[end][k] = index++;
                    }
                    flag = 3;
                } else {
                    for(int k = end; k > start; k--) {
                        result[k][start] = index++;
                    }
                    break;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        generateMatrix(3);
    }

}
