package offer10_2;

/**
 * @author CJR
 * @create 2021-10-27-21:24
 */
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：
输入：n = 2
输出：2

示例 2：
输入：n = 7
输出：21

示例 3：
输入：n = 0
输出：1

 */

//滑动数组
public class Solution {
    private static final int MOD = 1000000007;

    public int numWays(int n){
        if(n <= 1) return 1;
        int p=1,q=1,r=2;
        for (int i = 2; i < n; i++) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }

}
