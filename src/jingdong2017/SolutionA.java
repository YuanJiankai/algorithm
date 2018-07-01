package jingdong2017;

import java.util.Scanner;

/**
 * SolutionA.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/14
 * @since 1.8 or after
 */
public class SolutionA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int []curs = new int[n];
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            sum += m;
            curs[i] = sum;
        }
        int min = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, curs[i] - min);
            min = Math.min(min, Math.min(curs[i] - min, curs[i]));
        }
        System.out.println(max);
    }
}
