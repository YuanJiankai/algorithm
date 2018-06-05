package hard;

public class Problem_44_1 {

    public boolean isMatch(String s, String p) {
        StringBuilder sb = new StringBuilder();
        int len = p.length();
        boolean flag = true;
        for(int i = 0; i < len; i++) {
            if(p.charAt(i) == '*' && flag) {
                sb.append(p.charAt(i));
                flag = false;
            }
            if(p.charAt(i) != '*') {
                flag = true;
            }
        }
        return isMatchRecursion(s, sb.toString());
    }

    public boolean isMatchRecursion(String s, String p) {
        boolean flag = false;
        int lens = s.length();
        int lenp = p.length();
        if(lenp == 0 && lens == 0) {
            return true;
        }
        if(lenp == 0) {
            return flag;
        }
        if(lens == 0) {
            for(int i = 0; i < lenp; i++) {
                if(p.charAt(i) != '*') {
                    return flag;
                }
            }
            return true;
        }

        if(p.charAt(0) == '*') {
            flag = isMatch(lens == 1 ? "" : s.substring(1,lens), lenp == 1 ? "" : p.substring(1, lenp)) || isMatch(lens == 1 ? "" : s.substring(1,lens), p.substring(0, lenp))
            || isMatch(s.substring(0, lens), lenp == 1 ? "" : p.substring(1, lenp));
        } else if(p.charAt(0) == '?' || s.charAt(0) == p.charAt(0)) {
            flag = isMatch(lens == 1 ? "" : s.substring(1,lens), lenp == 1 ? "" : p.substring(1, lenp));
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_44_1().isMatch("babaaababaabababbbbbbaabaabbabababbaaba", "***bba**a*bbba**aab**b"));
    }
}
