package jingdong2017;

import java.util.Scanner;

/**
 * SolutionE.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/14
 * @since 1.8 or after
 */
public class SolutionE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] nums = new int[n + 1];
        long[][] dp = new long[n + 1][sum + 1];
        for(int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(nums[i] == j) {
                    dp[i][j]++;
                }
                dp[i][j] += dp[i - 1][j];
                if(j > nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        System.out.println(dp[n][sum]);
    }
}
