package hard;

/**
 * 很奇怪的动态规划问题
 */
public class Problem_309_1 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int buy = 0, pre_buy = Integer.MIN_VALUE, sell = 0, pre_sell = 0;
        for(int price : prices) {
            buy = Math.max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(sell, pre_buy + price);
            pre_buy = buy;
        }
        return sell;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_309_1().maxProfit(new int[]{1, 2, 4, 1, 5}));
    }
}
