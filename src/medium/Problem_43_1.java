package medium;

import java.util.ArrayList;
import java.util.List;

public class Problem_43_1 {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        String result = "";
        if (len1 == 0 || len2 == 0 || judgeZero(num1) || judgeZero(num2)) {
            return "0";
        }
        char[] cnum1, cnum2;
        if (len1 < len2) {
            cnum1 = num2.toCharArray();
            cnum2 = num1.toCharArray();
        } else {
            cnum1 = num1.toCharArray();
            cnum2 = num2.toCharArray();
        }
        List<String> list = new ArrayList<>();
        for (int i = cnum2.length - 1; i >= 0; i--) {
            list.add(multiplySimple(cnum2[i], cnum1));
        }
        if (list.size() != 1) {
            result = list.get(0);
            for (int i = 1, size = list.size(); i < size; i++) {
                result = addSimple(result.substring(0, result.length() - i + 1), list.get(i)) + result.substring(result.length() - i + 1, result.length());
            }
        } else {
            return list.get(0);
        }
        return result;
    }

    public String addSimple(String a, String b) {
        String num = a.substring(a.length() - 1);
        char[] numa = a.substring(0, a.length() - 1).toCharArray();
        char[] numb = b.toCharArray();
        int jin = 0;
        for (int lena = numa.length - 1, lenb = numb.length - 1; lena >= 0 || lenb >= 0; ) {
            int result = 0;
            if (lena >= 0 && lenb >= 0) {
                result = numa[lena--] + numb[lenb--] - 2 * '0' + jin;
            } else if (lena >= 0) {
                result = numa[lena--] - '0' + jin;
            } else {
                result = numb[lenb--] - '0' + jin;
            }
            num = (char) (result % 10 + '0') + num;
            jin = result / 10;
        }
        if (jin != 0) {
            num = (char) (jin + '0') + num;
        }
        return num;
    }

    public String multiplySimple(char num1, char[] num2) {
        String num = "";
        int jin = 0;
        int n = num1 - '0';
        for (int len = num2.length, i = len - 1; i >= 0; i--) {
            int result = (n * (num2[i] - '0') + jin) % 10;
            jin = (n * (num2[i] - '0') + jin) / 10;
            num = (char) (result + '0') + num;
        }
        if (jin != 0) {
            num = (char) (jin + '0') + num;
        }
        return num;
    }

    public boolean judgeZero(String a) {
        for(int i = 0, len = a.length(); i < len; i++) {
            if(a.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(123 * 234);
        System.out.println(new Problem_43_1().multiply("9", "99"));
    }
}
