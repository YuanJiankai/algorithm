package Contest1;

import org.junit.Test;

/**
 * Problem_498_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/30
 * @since 1.8 or after
 */
public class Problem_498_1 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int lenl = matrix.length; // 这个是矩阵行数
        int lenc = matrix[0].length; // 这个是矩阵列数
        int x = 0;
        int y = 0;
        int index = 0;
        int result[] = new int[lenl * lenc];
        result[index++] = matrix[x][y];
        if(result.length == 1) {
            return result;
        }
        int flag = 0; // 0 代表向上状态, 1 代表向下状态
        while (true) {
            if(flag == 0) {
                if(x - 1 >= 0 && y + 1 <= lenc - 1) {
                    result[index++] = matrix[--x][++y];
                } else if(x - 1 < 0 && y + 1 <= lenc - 1) {
                    result[index++] = matrix[x][++y];
                    flag = 1;
                } else {
                    result[index++] = matrix[++x][y];
                    flag = 1;
                }
            } else {
                if(x + 1 <= lenl - 1 && y - 1 >= 0) {
                    result[index++] = matrix[++x][--y];
                } else if(x + 1 <= lenl - 1 && y - 1 < 0) {
                    result[index++] = matrix[++x][y];
                    flag = 0;
                } else {
                    result[index++] = matrix[x][++y];
                    flag = 0;
                }
            }

            if(x == lenl - 1 && y == lenc - 1) {
                break;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1}};
        int[] result = findDiagonalOrder(matrix);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
