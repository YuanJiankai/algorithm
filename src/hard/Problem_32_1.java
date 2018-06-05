package hard;

import java.util.Stack;

public class Problem_32_1 {

    /**
     * 这个是单纯的用stack 来解决问题 不过还有一个更好的方法, 这个20%
     *
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] ss = s.toCharArray();
        int max = 0;
        for (int i = 0, len = ss.length; i < len; i++) {
            if (ss[i] == '(') {
                stack.push(i); // 这个地方很重要的 他是通过向栈中压入
            } else {
                if (!stack.isEmpty() && ss[stack.peek()] == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        if (stack.isEmpty()) {
            return ss.length;
        } else {
            int a = ss.length;
            while (!stack.isEmpty()) {
                max = Math.max(max, a - stack.peek() - 1);
                a = stack.pop();
            }
            max = Math.max(max, a - 0);
            return max;
        }
    }


    /**
     * 动态规划算法 当时离我自己想出来就差一步之遥...
     * 超过百分之98%
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        char[] ss = s.toCharArray();
        int max = 0;
        int len = ss.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (ss[i] == ')') {
                if (ss[i - 1] == '(') {
                    dp[i] = 2 + (i >= 3 ? dp[i - 2] : 0);
                } else if (dp[i - 1] > 0 && i - dp[i - 1] >= 1) {
                    if(ss[i - dp[i - 1] - 1] == '(') {
                        dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] >= 3 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_32_1().longestValidParentheses("()(())"));
    }
}
