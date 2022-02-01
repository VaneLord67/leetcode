package offer49;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CJR
 * @create 2022-02-01-17:51
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int a = 0;
        int b = 0;
        int c = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (n2 == dp[i]) a++;
            if (n3 == dp[i]) b++;
            if (n5 == dp[i]) c++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(1352));
    }
}
