package hard;

public class Problem_440_1 {
    public int findKthNumber(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n < k) return 0;
        if (n < 9) {
            return k;
        }
        int index = 1; // 标记走到哪
        k = k - 1; // 标记还要走几步
        while (k > 0) {
            int step = stepOneMethod(n, index, index + 1); //这个核心方法是通过树来判断我们要走到的那个index在哪棵树上
            if (step <= k) { //
                index = index + 1;
                k -= step;
            } else {
                index *= 10;
                k--;
            }
        }
        return index;
    }

    public static int stepOneMethod(int n, long n1, long n2) {
        int step = 0;
        while (n1 <= n) {
            step += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_440_1().findKthNumber(957747794, 424238336));
//        for(int i = 214735000; i < 300000000; i+=1000) {
//            System.out.println(stepOneMethod(i, 600000000));
//        }
    }
}
