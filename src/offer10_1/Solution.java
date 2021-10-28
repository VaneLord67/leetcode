package offer10_1;

/**
 * @author CJR
 * @create 2021-10-27-19:18
 */

/*
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
F(0) = 0
F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：
输入：n = 2
输出：1

示例 2：
输入：n = 5
输出：5

 */



//时间过长
public class Solution {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(new Solution().fib(45));
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l);
    }

    private static final int MOD = 1000000007;

    public int fib(int n) {
        int result = myFib(n);
        return result;
    }

    public int myFib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int result = myFib(n - 1) + myFib(n - 2);
        if(result > MOD){
            result -= MOD;
        }
        return result;
    }
}
