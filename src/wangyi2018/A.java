package wangyi2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/6
 * @since 1.8 or after
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 工作
        int m = sc.nextInt(); // 学生
        Work[] works = new Work[n];
        for(int i = 0; i < n; i++) {
            Work w = new Work(sc.nextInt(), sc.nextInt());
            works[i] = w;
        }
        Arrays.sort(works);
        int max = works[0].reward;
        for(int i = 1; i < n; i++) {
            if(max > works[i].reward) {
                works[i].reward = max;
            } else {
                max = works[i].reward;
            }
        }
        for(int i = 0; i < m; i++) {
            System.out.println(binarySearch(0, n - 1, works, sc.nextInt()));
        }
    }

    public static int binarySearch(int start, int end, Work[] works, int target) {
        int i = start;
        int j = end;
        while(i < j) {
            int mid = (i + j) / 2;
            if(works[mid].ability == target) {
                return works[mid].reward;
            } else if(works[mid].ability < target) {
                i = mid == j ? mid : mid + 1;
            } else {
                j = mid == i ? mid : mid - 1;
            }
        }

        if(target < works[i].ability) {
            return i == start ? 0 : works[i - 1].reward;
        } else {
            return works[i].reward;
        }
    }

    static class Work implements Comparable {
        public Work(int ability, int reward) {
            this.ability = ability;
            this.reward = reward;
        }

        int ability;
        int reward;

        @Override
        public int compareTo(Object o) {
            Work w = (Work) o;
            return this.ability - w.ability;
        }
    }
}
