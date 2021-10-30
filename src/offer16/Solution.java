package offer16;

/**
 * @author CJR
 * @create 2021-10-30-16:19
 */
public class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        double prod = 1.0;
        long b = n;
        if(b < 0){
            b = -b;
            x = 1 / x;
        }
        while(b > 0){
            if((b & 1) == 1){
                prod = prod * x;
            }
            x = x * x;
            b >>= 1;
        }
        return prod;
    }
}
