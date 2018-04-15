package easy;

public class Problem_14_1 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        String s = strs[0];
        for(int i = 1, len = strs.length; i < len; i++) {
            s = longestCommonPrefixMethod(strs[i], s);
        }
        return s;
    }
    public String longestCommonPrefixMethod(String a, String b) {
        int len = Math.min(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                return sb.toString();
            }
            sb.append(a.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem_14_1().longestCommonPrefix(new String[]{"abas", "abe", "abcd"}));
    }
}
