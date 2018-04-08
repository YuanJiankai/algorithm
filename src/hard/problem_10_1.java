package hard;

/**
 * 动态规划的方式实现正则匹配 36ms
 */
public class problem_10_1 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char sc[] = s.toCharArray();
        char pc[] = p.toCharArray();
        int dp[][] = new int[s.length() + 1][p.length() + 1];
        dp[0][0] = 1; // 默认假如是s, p都为空 直接跳过
        for (int i = 1; i <= pc.length; i++) { // 这个是为了构建一个匹配s为空情况的dp数组
            if (pc[i - 1] == '*') { // 这里只需要判断一下"*" 这种情况 如果dp[0][i - 1] == 1 那么他也是1, 如果他前头的不是1 他的值就是dp[0][i - 2]
                if (dp[0][i - 1] == 1 || (i > 1 && dp[0][i - 2] == 1)) {
                    dp[0][i] = 1;
                }
            }
        }
        for (int i = 1; i <= s.length(); i++) { // 这里是用来生成动态规划数组的
            for (int j = 1; j <= p.length(); j++) {
                if (pc[j - 1] == '.' || pc[j - 1] == sc[i - 1]) { // 如果这个为'.' 或者和s[i -1]相同 说明pc[j - 1]可以独自匹配下一个, 他的dp就等于对角线的值
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (pc[j - 1] == '*') { // 如果他是* 就需要做两个判断
                    if (pc[j - 2] != sc[i - 1] && pc[j -2] != '.') { // 第一个假如 他的前一个不等于'.'而且也不和他相等
                        dp[i][j] = dp[i][j -2]; // 他的值只受制于 他的前两个 也就是例如a* 这种情况被舍弃
                    } else { // 否则就有三种情况 如下:
                        dp[i][j] = dp[i - 1][j] == 1 || dp[i][j - 1] == 1 || dp[i][j - 2] == 1 ? 1 : 0;
                    }
                }
            }
        }
        return dp[s.length()][p.length()] == 1;
    }

    public static void main(String[] args) {
        System.out.println(new problem_10_1().isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
    }
}
