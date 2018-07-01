package jingdong2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * SolutionC.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/14
 * @since 1.8 or after
 */
public class SolutionC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        List<List<Coord>> list = new ArrayList<>();
        List<Coord> result = new ArrayList<>();
        backMethod(map, result, 0, 0, p, list);
        if (list.size() > 0) {
            list = list.stream().sorted((i, j) -> {
                return i.size() - j.size();
            }).collect(Collectors.toList());
            System.out.println(list.get(0).stream().map(c -> {
                return String.format("[%d,%d]", c.x, c.y);
            }).collect(Collectors.joining(",")));
        } else {
            System.out.println("Can not escape!");
        }
    }

    public static void backMethod(int map[][], List<Coord> result, int x, int y, int p, List<List<Coord>> resultList) {
        if(x < 0 || x > map.length - 1 || y < 0 || y > map[0].length - 1 || p < 0 || map[x][y] == 0) {
            return;
        }
        Coord c = new Coord(x, y);
        result.add(c);
        if(x == 0 && y == map[0].length - 1) {
            List<Coord> list = new ArrayList();
            list.addAll(result);
            resultList.add(list);
            return;
        }
        map[x][y] = 0;
        backMethod(map, result, x, y - 1, p - 1, resultList); //向左
        backMethod(map, result, x, y + 1, p - 1, resultList); //向右
        backMethod(map, result, x - 1, y, p - 3, resultList); //向上
        backMethod(map, result, x + 1, y, p, resultList); //向下
        map[x][y] = 1;
        result.remove(c);
    }

    static class Coord {
        int x;
        int y;
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
