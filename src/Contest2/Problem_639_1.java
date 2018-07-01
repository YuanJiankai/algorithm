package Contest2;

/**
 * Problem.java
 * Description: 做的很乱 明天把他好好地理一下....
 *
 * @author v_yuanjiankai
 * @date 2018/6/30
 * @since 1.8 or after
 */
public class Problem_639_1 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        long sum1 = 1;
        long sum2 = 1;
        int mod = 1000000007;
        for (int i = 0; i < len; i++) {
            char a = s.charAt(i);
            if (i == 0) {
                if (a == '0') {
                    return 0;
                }
                if (a == '*') {
                    sum2 = sum2 * 9;
                }
            } else {
                char b = s.charAt(i - 1);
                if (b == '0') {
                    if (a == '0') {
                        return 0;
                    }
                    sum1 = sum2;
                    if (a == '*') {
                        sum2 = sum2 * 9 % mod;
                    }
                    continue;
                }
                long sum3 = 0;
                if (a == '*') {
                    if (b == '*') {
                        sum3 = sum1 * 15 % mod;
                    } else {
                        sum3 = sum1 * (b == '1' ? 9 : b == '2' ? 6 : 0);
                    }
                    sum1 = sum2;
                    sum2 = (sum3 + sum2 * 9) % mod;
                } else {
                    if(a == '0' && b > '2') {
                        return 0;
                    }
                    if (b == '*') {
                        if (a <= '6' && a >= '1') {
                            sum3 = sum1 * 2;
                        } else {
                            sum3 = sum1;
                        }
                        sum1 = sum2;
                        sum2 = a == '0' ? sum3 * 2 : (sum2 + sum3) % mod;
                    } else {
                        if (b == '1' || (b == '2' && a <= '6')) {
                            sum3 = sum1;
                            sum1 = sum2;
                            sum2 = a == '0' ? sum3 : (sum2 + sum3) % mod;
                        }
                    }
                }
            }
        }
        return Integer.valueOf(String.valueOf(sum2));
    }
}
