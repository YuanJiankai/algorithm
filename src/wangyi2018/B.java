package wangyi2018;

import org.junit.Test;

import java.util.Scanner;

/**
 * B.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/7
 * @since 1.8 or after
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int sum = 0;
        for(int i = k; i < n; i++) {
            sum += n - i;
        }
    }

    @Test
    public void test() {
        int[] n = new int[21];
        n[1] = 1;
        n[2] = 1;
        n[3] = 2;
        for(int i = 4; i < 21; i++) {
            n[i] = n[i - 3] + n[i - 1];
            System.out.println(i + "  " + n[i]);
        }
    }
}
