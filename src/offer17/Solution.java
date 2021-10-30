package offer17;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * @author CJR
 * @create 2021-10-30-16:26
 */

/*
剑指 Offer 17. 打印从1到最大的n位数
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().printNumbers_(30);
    }

    public void printNumbers_(int n){
        BigInteger tmp = BigInteger.valueOf(1);
        BigInteger bigTen = BigInteger.valueOf(10);
        BigInteger pow = bigTen.pow(n);
        while(tmp.compareTo(pow) < 0){
            System.out.println(tmp);
            tmp = tmp.add(BigInteger.valueOf(1));
        }
    }

    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10,n) - 1;
        return IntStream.rangeClosed(1,max).toArray();
    }
}
