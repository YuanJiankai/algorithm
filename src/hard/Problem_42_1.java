package hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem_42_1 {
    /**
     * 自己独立完成的 思想感觉还不错 就是时间复杂度有点尴尬................ 超越9.8%
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int len = height.length;
        if (len <= 2) {
            return 0;
        }
        int[] d = new int[len]; // 这个是很核心的数组 它代表对应你要 求哪个节点的面积, 你就要把他给排除出去
        Stack<Integer> stack = new Stack<>();
        int sum = 0; // 存的是总面积
        for (int i = 0; i < len; i++) {
            if (height[i] == 0) {
                continue;
            }
            if (stack.isEmpty()) {  // 如果栈是空的入栈
                stack.push(i);
                continue;
            }
            int top = stack.peek(); // 代表的是栈顶元素位置
            int topVal = height[top]; // 代表的是栈顶元素的值
            while(topVal <= height[i]) { // 这一步是判断一下 当前元素和栈顶元素的值的大小区别 直到找到一个比他大或者空栈的再入栈
                if (top + 1 == i) { // 如果两个元素连着的话 我们要找到 和他相等 或者是比他大的继续判断, 如果栈空了就入栈
                    stack.pop();
                    if (stack.isEmpty()) { // 如果出栈一个之后 栈空了 直接break 讲这个i push进去
                        break;
                    }
                    top = stack.peek();
                    d[top] += topVal;
                    topVal = height[top];
                    if(height[i] < height[top]) { // 如果发现 栈中的下一个节点的高度更高, 入栈 不执行计算操作
                        break;
                    }
                }
                // 开始计算, 这个最核心的是什么算进去 什么不应该算进去
                int cur = (i - top - 1) * topVal - d[top]; // 求一下面积
                sum += cur; // 加入sum
                stack.pop(); // 出
                if (!stack.isEmpty()) {
                    d[stack.peek()] += (i - top) * topVal; // 把你已经求过面积的部分加到 下一个节点需要排除的面积中
                    top = stack.peek();
                    topVal = height[top];
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        // 这一步是对栈里的残留值进行求和
        if (stack.isEmpty()) {
            return sum;
        } else {
            int c = stack.pop();
            while (!stack.isEmpty()) {
                int p = stack.peek();
                int num = (c - p - 1) * height[c] - d[p];
                if (num > 0) {
                    sum += num;
                }
                c = stack.pop();
            }
            return sum;
        }
    }

    /**
     * 再写一种我之前觉得还好的方法
     * 好吧我错了 这个确实超时了.. (尴尬) 我在写的时候就感觉到了他的复杂度是很高的, 果然超时了  以后暂时相信一下leetcode 不会以为他是智障了..
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 2) {
            return 0;
        }
        int sum = 0;
        int count;
        boolean judge = true; // 判断是不是还需要执行
        boolean flag;
        while(judge) {
            judge = false;
            flag = false;
            count = 0;
            for(int i = 0; i < len; i++) {
                if(height[i] > 0) {
                    if(flag == false) {
                        flag = true;
                    } else {
                        sum += count;
                        count = 0;
                        judge = true;
                    }
                    height[i]--;
                } else {
                    if(flag == true) {
                        count++;
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] n = new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
        int[] nn = new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
        System.out.println(new Problem_42_1().trap(nn));
        Queue<Integer> q = new LinkedList<Integer>();
        boolean flag = true;
        while (flag) {
            flag = false;
            int max = 0;
            for (int i = 0; i < n.length; i++) {
                if (n[i] > max) {
                    max = n[i];
                    q = new LinkedList<>();
                    q.add(i);
                } else if (max != 0 && n[i] == max) {
                    q.add(i);
                }
            }

            if (max == 0) {
                break;
            } else {
                flag = true;
            }

            int x = q.poll();
            for (int i = 0; i < n.length; i++) {
                if (i == x) {
                    n[i]--;
                    if (!q.isEmpty()) {
                        x = q.poll();
                    }
                    System.out.print("##");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for(int i = 0; i < n.length; i++) {
            if(i < 10) {
                System.out.print(i + " ");
            } else {
                System.out.print(i);
            }
        }
    }
}
