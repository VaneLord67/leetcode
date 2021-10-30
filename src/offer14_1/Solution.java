package offer14_1;

/**
 * @author CJR
 * @create 2021-10-30-14:16
 */

/*
剑指 Offer 14- I. 剪绳子
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Solution {

    // 数学推导方法(贪心算法，尽量剪长度为3的绳子)
//    public int cuttingRope(int n) {
//        if(n <= 3) return n - 1;
//        int a = n / 3;
//        int b = n % 3;
//        if(b == 0) return (int)Math.pow(3,a);
//        if(b == 1) return (int)Math.pow(3,a-1) * 4;
//        return (int)Math.pow(3,a) * 2;
//    }

    // 动态规划算法
    public int cuttingRope(int n){
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i],Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }


}
