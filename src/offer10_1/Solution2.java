package offer10_1;

/**
 * @author CJR
 * @create 2021-10-27-19:46
 */

//动态规划，滑动数组
    //时间复杂度O（N） 空间复杂度O（1）
public class Solution2 {
    private static final int MOD = 1000000007;
    public int fib(int n){
        if(n < 2) return n;
        int p=0,q=0,r=1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }

        return r;
    }
}
