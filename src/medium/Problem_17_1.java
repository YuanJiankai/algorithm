package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 我自己的想法
 * 准备用流来写, 不确定时间复杂度怎么样, 但是应该不低
 */
public class Problem_17_1 {
    private static Map<Character, List<String>> numMap = new HashMap<>();
    static {
        numMap.put('2', Arrays.asList("a", "b", "c"));
        numMap.put('3', Arrays.asList("d", "e", "f"));
        numMap.put('4', Arrays.asList("g", "h", "i"));
        numMap.put('5', Arrays.asList("j", "k", "l"));
        numMap.put('6', Arrays.asList("m", "n", "o"));
        numMap.put('7', Arrays.asList("p", "q", "r", "s"));
        numMap.put('8', Arrays.asList("t", "u", "v"));
        numMap.put('9', Arrays.asList("w", "x", "y", "z"));
    }
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        list.addAll(numMap.get(digits.charAt(0)));
        for(int i = 1, len = digits.length(); i < len; i++) {
            List<String> list_1 = new ArrayList<>();
            for(int j = 0, lenm = numMap.get(digits.charAt(i)).size(); j < lenm; j++) {
                List<String> s = new ArrayList<>();
                for(int x = 0, lenl = list.size(); x < lenl; x++) {
                    s.add(list.get(x) + numMap.get(digits.charAt(i)).get(j));
                }
                list_1.addAll(s);
            }
            list = list_1;
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_17_1().letterCombinations("24592534"));
    }
}
