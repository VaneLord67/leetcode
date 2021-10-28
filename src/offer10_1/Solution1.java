package offer10_1;

/**
 * @author CJR
 * @create 2021-10-27-19:36
 */


//使用一个一维数组保存前面的结果
    //时间空间复杂度O（n）
public class Solution1 {
    private static final int MOD = 1000000007;
    public int fib(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] = dp[i] % MOD;
        }

        return dp[n];
    }
}
