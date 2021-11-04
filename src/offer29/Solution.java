package offer29;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CJR
 * @create 2021-11-04-23:50
 */

/*
剑指 Offer 29. 顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */

// 有限状态机
class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3,4}, {5, 6,7,8}, {9,10,11,12}};
        System.out.println(Arrays.toString(new Solution().spiralOrder(matrix)));
    }

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[]{};
        }
        Map<Direc,Direc> map = new HashMap<Direc,Direc>(){{
            put(Direc.RIGHT,Direc.DOWN);
            put(Direc.DOWN,Direc.LEFT);
            put(Direc.LEFT,Direc.UP);
            put(Direc.UP,Direc.RIGHT);
        }};
        int i = 0;
        int j = 0;
        int cnt = 0;
        int lineLength = matrix.length;
        int columnLength = matrix[0].length;
        boolean[][] visit = new boolean[lineLength][columnLength];
        Direc direc = Direc.RIGHT;
        int[] ints = new int[lineLength * columnLength];
        while (cnt != lineLength * columnLength) {
            if (visit[i][j]) {
                if (direc == Direc.UP) {
                    i++;
                }
                if (direc == Direc.DOWN) {
                    i--;
                }
                if (direc == Direc.LEFT) {
                    j++;
                }
                if (direc == Direc.RIGHT) {
                    j--;
                }
                direc = map.get(direc);
            } else {
                ints[cnt++] = matrix[i][j];
                visit[i][j] = true;
            }
            if (direc == Direc.RIGHT) {
                j++;
                if (j >= columnLength) {
                    direc = map.get(direc);
                    j--;
                }
            }
            if (direc == Direc.DOWN) {
                i++;
                if (i >= lineLength) {
                    direc = map.get(direc);
                    i--;
                }
            }
            if (direc == Direc.LEFT) {
                j--;
                if (j < 0) {
                    direc = map.get(direc);
                    j++;
                }
            }
            if (direc == Direc.UP) {
                i--;
                if (i < 0) {
                    direc = map.get(direc);
                    i++;
                }
            }
        }
        return ints;
    }

    enum Direc {
        RIGHT,
        LEFT,
        DOWN,
        UP
    }

}