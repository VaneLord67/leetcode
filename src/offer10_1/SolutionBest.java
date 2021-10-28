package offer10_1;

/**
 * @author CJR
 * @create 2021-10-27-20:38
 */

//矩阵快速幂
    //时间复杂度O（logn） 空间复杂度O（1）
public class SolutionBest {
    static final int MOD = 1000000007;

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        //二阶单位矩阵，它相当于是一个连乘器，保存幂结果。可以理解成快速幂中的prod=1
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            //n是奇数时，更新连乘器，
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            // n除以2
            n >>= 1;
            //更新底数
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return c;
    }

}
