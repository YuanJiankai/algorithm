package hard;

/**
 * 之前觉得ok的DP的写法
 */
public class Problem_188_2 {
    public int maxProfit(int k, int[] prices) {
        int l = prices.length;
        if(l == 0 || k == 0) {
            return 0;
        }
        if(k >= l / 2) {
            return quickSum(prices);
        }
        int dp[][] = new int[k + 1][l];
        for(int i = 1; i <= k; i++) {
            int min = prices[0];
            for(int j = 1, len = l; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
                min = Math.min(prices[j] - dp[i - 1][j - 1], min);
            }
        }
        return dp[k][l - 1];
    }
    public int quickSum(int[] prices) { // 不加这个速度会慢很多.. 当然我也很绝望 其实他就是用来解决数据量很大的问题
        int sum = 0;
        for(int i = 0, len = prices.length; i < len - 1; i++) {
            if(prices[i + 1] > prices[i]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.print(new Problem_188_2().maxProfit(100, new int[]{1, 2, 4, 2, 1, 5}));
    }
}
