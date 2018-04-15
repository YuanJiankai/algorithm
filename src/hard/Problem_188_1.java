package hard;

/**
 * 回溯法 解决这个问题 (超时时间复杂度太高, 不适用)
 */
public class Problem_188_1 {
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length == 0) {
            return 0;
        }
        return maxPro(2, 1, 0, k, prices, 0);
        // flag 1:zeng 2:jian  fp 1: mei 0: mai
    }

    public int maxPro(int flag , int fp, int n, int k, int[] prices, int price) {
        int max = 0;
        int sum = 0;
        for (int i = n, len = prices.length; i < len && k >= 0; i++) {
            flag = trendJudge(flag, i, prices);
            if (fp == 1) {
                if (flag == 1) {
                    price = prices[i];
                    fp = 0;
                    k--;
                }
            } else {
                if (flag == 2) {
                    max = Math.max(Math.max(maxPro(2, 1, i + 1, k + 1, prices, 0) + sum, maxPro(2, 0, i + 1, k, prices, price) + sum), max);
                    sum += prices[i] - price;
                    fp = 1;
                }
            }
        }
        sum = Math.max(sum, max);
        return sum;
    }

    public int trendJudge(int flag, int index, int[] prices) {
        if (index == prices.length - 1) {
            return flag == 1 ? 2 : 1;
        }
        if (flag == 1 && prices[index + 1] < prices[index]) {
            flag = 2;
        } else if (flag == 2 && prices[index + 1] > prices[index]) {
            flag = 1;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.print(new Problem_188_1().maxProfit(2, new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
