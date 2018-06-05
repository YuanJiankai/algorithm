package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem_36_1 {

    /**
     * 很low的方法 判断起来很复杂
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 感觉应该不用
        for(int i = 0; i < 9; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(!map.containsKey(board[i][j])) {
                    map.put(board[i][j], 1);
                } else{
                    return false;
                }
            }
        }
        for(int i = 0; i < 9; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for(int j = 0; j < 9; j++) {
                if(board[j][i] == '.') {
                    continue;
                }
                if(!map.containsKey(board[j][i])) {
                    map.put(board[j][i], 1);
                } else{
                    return false;
                }
            }
        }
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                Map<Character, Integer> map = new HashMap<>();
                for(int x = i; x < i + 3; x++) {
                    for(int y = j; y < j + 3; y++) {
                        if(board[x][y] == '.') {
                            continue;
                        }
                        if(!map.containsKey(board[x][y])) {
                            map.put(board[x][y], 1);
                        } else{
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * very nice 的方法 实在是不知道怎么形容了
     * 思路真的好时间不重要了 60% 几个时间
     * @param
     */
    public boolean isValidSudoku2(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if(!set.add(number + " row " + i) || !set.add(number + " column " + j) || !set.add(number + " area " + i / 3 + " " + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_36_1().isValidSudoku2(new char[][] {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}}
        ));
        char[][] a =  {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
