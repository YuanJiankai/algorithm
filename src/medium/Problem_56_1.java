package medium;

import entity.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Problem_56_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/14
 * @since 1.8 or after
 */
public class Problem_56_1 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        int size = intervals.size();
        if (size == 0) {
            return new ArrayList<>();
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
//        for(Interval i : intervals) {
//            System.out.println(i.start);
//        }
        for (int i = 1; i < size; i++) {
            if (intervals.get(i).start > end) {
                list.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            } else {
                if (intervals.get(i).end > end) {
                    end = intervals.get(i).end;
                }
            }
        }
        list.add(new Interval(start, end));
        return list;
    }
}
