package medium;

public class Problem_11_1 {
    public int maxArea(int[] height) {
        if(height.length == 1 || height.length == 0) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int start = height[i];
        int end = height[j];
        int max = Integer.MIN_VALUE;
        while(i < j) {
            max = Math.max(max, Math.min(start, end) * (j - i));
            if(start > end) {
                j = j -1;
                end = Math.max(end, height[j]);
            } else {
                i = i + 1;
                start = Math.max(start, height[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // System.out.println(new Problem_11_1().maxArea(new int[]{1,2}));
    }
}
