package medium;

import java.util.ArrayList;
import java.util.List;

public class problem_8_1 {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                index = i;
                break;
            }
        }
        char s[] = str.substring(index, str.length()).toCharArray();
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < s.length; i++) {
            if (i == 0 && (s[i] == '+' || s[i] == '-')) {
                flag = s[i] == '+' ? true : false;
                continue;
            }
            if (s[i] > '9' || s[i] < '0') {
                break;
            }
            list.add(s[i] - '0');
        }
        int len = list.size();
        if (len == 0) {
            return 0;
        }
        long l = 0;
        for (int i = 0; i < list.size(); i++) {
            l += list.get(i) * Math.pow(10, list.size() - 1 - i);
            if(flag == true) {
                if (Math.abs(l) > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            } else {
                if (Math.abs(l) < Math.abs(Integer.MIN_VALUE)) return Integer.MAX_VALUE;
            }
        }
        if (flag == true) {
            return l > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) l;
        } else {
            return l > -(long) (Integer.MIN_VALUE) ? Integer.MIN_VALUE : (int) -l;
        }
    }

    public static void main(String[] args) {
        System.out.println(new problem_8_1().myAtoi("  -012r00001"));
    }


}
