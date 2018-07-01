package jingdong2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * SolutionB.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/14
 * @since 1.8 or after
 */
public class SolutionB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> numsn = new ArrayList<>();
        Customer[] customers = new Customer[m];
        for (int i = 0; i < n; i++) {
            numsn.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            Customer c = new Customer();
            c.num = sc.nextInt();
            c.consume = sc.nextInt();
            customers[i] = c;
        }
        Arrays.sort(customers);
        Collections.sort(numsn);
        int size = n;
        Long sum = 0l;
        for (int i = 0; i < m; i++) {
            if (size == 0) {
                break;
            }
            int index = binarySearch(numsn, customers[i].num);
            if (index == -1) {
                continue;
            } else {
                numsn.remove(index);
                sum += customers[i].consume;
                size--;
            }
        }
        System.out.println(sum);
    }

    public static int binarySearch(List<Integer> list, int target) { // 好好理解一下 关于不是search准确的值而是大于或小于值
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if(target <= list.get(mid)) {
                end = start ==  mid ? mid : mid - 1;
            } else {
                start = end == mid ? mid : mid + 1;
            }
        }
        if (list.get(start) < target) {
            return start == list.size() - 1 ? -1 : start + 1;
        } else {
            return start;
        }
    }

    public static class Customer implements Comparable {
        int num;
        int consume;

        @Override
        public int compareTo(Object o) {
            Customer c = (Customer) o;
            return c.consume - this.consume;
        }
    }
}
