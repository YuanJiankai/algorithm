package easy;

public class Problem_20_1 {
    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 != 0) {
            return false;
        }
        char[] stack = new char[len / 2 + 1];
        int index = 0;
        char ss[] = s.toCharArray();
        for(int i = 0; i < len; i++) {
            if (ss[i] == '(' || ss[i] == '[' || ss[i] == '{') {
                stack[index++] = ss[i];
            } else {
                if (index == 0) {
                    return false;
                } else {
                    char a = stack[--index];
                    if(!((ss[i] == '}' && a == '{') || (ss[i] == ']' && a == '[') || (ss[i] == ')' && a == '('))) {
                        return false;
                    }
                }
            }
        }

        if(index == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem_20_1().isValid("[](){}"));
    }
}
