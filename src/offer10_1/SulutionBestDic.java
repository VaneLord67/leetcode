package offer10_1;

/**
 * @author CJR
 * @create 2021-10-27-21:10
 */
public class SulutionBestDic {
    static final int MOD = 1000000007;

    public int fib(int n) {
        if(n < 2) return n;
        int[][] m = {{1,1},{1,0}};
        int[][] res = quickMuiltiply(m,n-1);
        return res[0][0];
    }

    public int[][] quickMuiltiply(int[][] a,int n){
        int[][] prod = {{1,0},{0,1}};
        while(n > 0){
            if((n & 1) == 1){
                prod = multiply(prod,a);
            }
            a = multiply(a,a);
            n >>= 1;
        }
        return prod;
    }

    public int[][] multiply(int[][] a,int[][] b){
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
//                c[i][j] = (a[i][0] * b[0][j] + a[i][1] * b[1][j]) % MOD; 改成下面
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return c;
    }
}
