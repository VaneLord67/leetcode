package offer04;

/**
 * @author CJR
 * @create 2021-10-27-0:17
 */

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int i = 0;
        int j = matrix[0].length - 1;
        while(i >= 0 && i <= matrix.length - 1 && j >= 0 && j <= matrix[i].length - 1){
            if(matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] < target){
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
//    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        for (int[] num : matrix) {
//            for (int n: num) {
//                if(n == target){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

}
