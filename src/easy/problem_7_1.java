package easy;

public class problem_7_1 {
    public int reverse(int x) {
        if(x == 0) return 0;
        boolean flag = true;
        String num = String.valueOf(x);
        char a[] = null;
        if (x < 0) {
            flag = false;
            a = num.substring(1, num.length()).toCharArray();
        } else {
            a = num.toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = a.length - 1; i >= 0; i--) {
            sb.append(a[i]);
        }
        if(Long.valueOf(sb.toString()) > Integer.MAX_VALUE) {
            return 0;
        }
        if(flag == true) {
            return Integer.valueOf(sb.toString());
        } else {
            return -Integer.parseInt(sb.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(new problem_7_1().reverse(-2147483648));
    }
}
