package Contest2;

import org.junit.Test;

/**
 * Problem_640_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/30
 * @since 1.8 or after
 */
public class Problem_640_1 {
    public String solveEquation(String equation) {
        String exp1 = "";
        String exp2 = "";
        int index = equation.indexOf("=");
        exp1 = equation.substring(0, index);
        exp2 = equation.substring(index + 1, equation.length());
        int countx1 = 0;
        int countx2 = 0;
        int count1 = 0;
        int count2 = 0;
        int[] result = method(exp1);
        count1 = result[0];
        countx1 = result[1];
        result = method(exp2);
        count2 = result[0];
        countx2 = result[1];
        int x1 = countx1 -= countx2;
        int x2 = count2 -= count1;
        if(x1 == 0) {
            return x2 == 0 ? "Infinite solutions" : "No solution";
        } else {
            return String.valueOf("x=" + x2 / x1);
        }
    }
    public int[] method (String s) {
        int countx = 0;
        int count = 0;
        int len = s.length();
        boolean flag = true; // true add , false del
        for(int i = 0; i < len; i++) {
            char a = s.charAt(i);
            if(a != ' ') {
                if(a <= '9' && a >= '0') {
                    String num = String.valueOf(s.charAt(i));
                    while(true) {
                        if(i + 1 == len) {
                            if (flag) {
                                count += Integer.valueOf(num);
                            } else {
                                count -= Integer.valueOf(num);
                            }
                            break;
                        }
                        if(s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0') {
                            num += s.charAt(i + 1);
                            i++;
                        } else {
                            if(s.charAt(i + 1) ==  'x') {
                                if(flag) {
                                    countx += Integer.valueOf(num);
                                } else {
                                    countx -= Integer.valueOf(num);
                                }
                                i++;
                            }else {
                                if (flag) {
                                    count += Integer.valueOf(num);
                                } else {
                                    count -= Integer.valueOf(num);
                                }
                            }
                            break;
                        }
                    }
                }
                if(a == 'x') {
                    if(flag) {
                        countx++;
                    } else {
                        countx--;
                    }
                }
                if(a == '+') {
                    flag = true;
                }
                if(a == '-') {
                    flag = false;
                }
            }
        }
        return new int[]{count, countx};
    }

    @Test
    public void test() {
        System.out.println(solveEquation("3x=33+22+11"));
    }
}
