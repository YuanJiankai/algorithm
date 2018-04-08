package hard;

/**
 * 递归方法实现正则匹配 96ms
 */
public class Problem_10_2 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return regular(s, p);
    }

    public boolean regular(String s, String p) {
        boolean flag = false;

        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            if (s.length() == 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
                flag = true;
            }
            return flag;
        }
        if (p.charAt(1) == '*') {
            flag = isMatch(s, p.substring(2)) || ((s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) ? isMatch(s.substring(1), p) : false);
        } else {
            if (s.length() != 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
                flag = isMatch(s.substring(1), p.substring(1));
            }
            return flag;
        }
        return flag;
    }
    public static void main(String[] args) {
        System.out.print(new Problem_10_2().isMatch("abcd", ".*"));
    }
}
