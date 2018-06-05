package medium;

import java.util.*;

/**
 * Problem_49_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/3
 * @since 1.8 or after
 */
public class Problem_49_1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len;
        if (strs == null || (len = strs.length) == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(strs);
        List<String> list = new ArrayList<>();
        for(String s : strs) {
            list.add(s);
        }
        List<List<String>> result = new ArrayList<>();
        while(list.size() != 0) {
            List<String> l = new ArrayList<>();
            String s = list.get(0);
            l.add(s);
            list.remove(0);
            int index = -1;
            while((index = binarySearch(list, s)) != -1) {
                s = list.get(index);
                l.add(s);
                list.remove(index);
            }
            result.add(l);
        }
        return result;
    }
    public int binarySearch(List<String> list, String t) {
        if(t == null || t.length() == 0) {
            return -1;
        }
        char target = t.charAt(0);
        if(list.size() == 0) {
            return -1;
        }
        int start = 0;
        int end = list.size() - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(list.get(mid).charAt(0) == target) {
                return mid;
            } else if(list.get(mid).charAt(0) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
