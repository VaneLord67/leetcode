package offer14_2;

/**
 * @author CJR
 * @create 2021-10-30-14:43
 */
public class Solution {
    public static final int MOD = 1000000007;

    public int cuttingRope(int n) {
        if(n <= 3) return n-1;
        int a = n / 3;
        int b = n % 3;
        if(b == 0) return (int) (pow(3,a) % MOD);
        if(b == 1) return (int) (pow(3,a-1) * 4 % MOD);
        return (int) (pow(3,a) * 2 % MOD);
    }

    public long pow(int x,int n){
        long prod = 1;
        long tt = x;
        while(n > 0){
            if((n & 1) == 1) {
                prod = prod * tt;
                prod %= MOD;
            }
            tt *= tt;
            tt %= MOD;
            n >>= 1;
        }
        return prod;
    }
}
