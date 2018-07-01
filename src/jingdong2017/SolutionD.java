package jingdong2017;

import java.util.Scanner;

/**
 * SolutionD.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/14
 * @since 1.8 or after
 */
public class SolutionD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int m = sc.nextInt();
        if(m < 0) {
            m = -m;
            flag = false;
        }
        int n = sc.nextInt();
        char[] system = new char[n + 1];
        system[0] = '0';
        for(int i = 1; i <= n; i++) {
            if(i >= 10) {
                system[i] = (char) ('A' + i - 10);
            } else {
                system[i] = (char) (i + '0');
            }
        }
        String result = "";
        while(m > 0) {
            int t = m % n;
            m = m / n;
            result = system[t] + result;
        }
        System.out.println(flag == true ? result : "-" + result);
    }
}
