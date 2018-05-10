package medium;

import java.util.ArrayList;
import java.util.List;

public class Problem_22_1 {
    private List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }
        recursionParenthesis(1, 0, "(", n);
        return list;
    }
    public List<String> recursionParenthesis(int l, int r, String s, int n) {
        if(l == r) {
             if(l == n) {
                 list.add(s);
             } else {
                 recursionParenthesis(l + 1, r, s + "(", n);
             }
        } else {
            if(l == n) {
                recursionParenthesis(l, r + 1, s + ")", n);
            } else {
                recursionParenthesis(l + 1, r, s + "(", n);
                recursionParenthesis(l, r + 1, s + ")", n);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_22_1().generateParenthesis(1));
    }
}
